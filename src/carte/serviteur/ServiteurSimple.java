package carte.serviteur;

import carte.serviteur.state.Etat;
import carte.serviteur.state.EtatAttaque;
import carte.serviteur.state.EtatDormir;
import main.Log;
import observer.IObserverServiteur;
import observer.Observer;
import observer.Sujet;

import java.util.ArrayList;

public class ServiteurSimple implements Sujet, Serviteur {

    private int PM;
    private String nom;
    private int PV;
    private int PD;

    private Etat etatDormir;
    private Etat etatAttaque;
    private Etat etatCourant;

    private ArrayList<IObserverServiteur> observers;

    public ServiteurSimple(String nom, int PM, int PD, int PV) {
        this.PM = PM;
        this.nom = nom;
        //init du state
        this.etatAttaque = new EtatAttaque(this);
        this.etatDormir = new EtatDormir(this);
        this.etatCourant = this.etatDormir;

        //init de l'observer
        this.observers = new ArrayList<>();
        setDonnees(PV, PD);
    }

    public int getPV() {
        return PV;
    }

    public int getPD() {
        return PD;
    }

    public int getPM() {
        return PM;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean estReveille() {
        return etatCourant.peutAttaquer();
    }

    @Override
    public String toString() {
        return "Serviteur [" + nom + " - " + PM + "/" + PD + "/" + PV + " - " + etatCourant + "]";
    }

    public void supprimerPV(int PV) {
        setDonnees(this.PV - PV, this.PD);
    }

    public void ajouterPV(int PV) {
        setDonnees(this.PV + PV, this.PD);
    }

    public void supprimerPD(int PD) {
        setDonnees(this.PV, (this.PD - PD >= 0 ? this.PD - PD : 0));
    }

    public void ajouterPD(int PD) {
        setDonnees(this.PV, this.PD + PD);
    }

    //méthodes du state

    public void changerEtatAttaquer() {
        etatCourant = etatAttaque;
    }

    public void changerEtatDormir() {
        etatCourant = etatDormir;
    }

    //méthodes de l'observer

    @Override
    public void enregistrerObs(Observer o) {
        if (o instanceof IObserverServiteur) {
            observers.add((IObserverServiteur) o);
        } else {
            Log.error("l'observeur n'a pas pu être ajouté");
        }
    }

    @Override
    public void supprimerObs(Observer o) {
        if (o instanceof IObserverServiteur) {
            observers.remove((IObserverServiteur) o);
        } else {
            Log.error("l'observeur n'a pas pu être supprimé");
        }
    }

    @Override
    public void notifierObs() {
        for (IObserverServiteur o : this.observers) {
            o.actualiser(PV, PD);
        }
    }

    public void setDonnees(int PV, int PD) {
        this.PV = PV;
        this.PD = PD;

        notifierObs();
    }

    @Override
    public boolean charger() {
        return false;
    }

    @Override
    public boolean volerVie() {
        return false;
    }

    @Override
    public boolean encourager() {
        return false;
    }

    @Override
    public boolean provoquer() {
        return false;
    }

    @Override
    public boolean isSort() {
        return false;
    }

    @Override
    public boolean isServiteur() {
        return true;
    }

}
