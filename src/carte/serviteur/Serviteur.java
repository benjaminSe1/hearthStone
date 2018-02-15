package carte.serviteur;

import java.util.ArrayList;

import carte.Carte;
import carte.serviteur.state.Etat;
import carte.serviteur.state.EtatAttaque;
import carte.serviteur.state.EtatDormir;

public abstract class Serviteur implements Carte {

    private int PM;
    private String nom;
    private int PV;
    private int PD;

    private Etat etatDormir;
    private Etat etatAttaque;
    private Etat etatCourant;

    public Serviteur(String nom, int PM, int PD, int PV){
        this.PM = PM;
        this.nom = nom;
        //init du state
        this.etatAttaque = new EtatAttaque(this);
        this.etatDormir = new EtatDormir(this);
        this.etatCourant = this.etatDormir;
        setDonnees(PV, PD);
    }

    public Serviteur() {
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

    public void setPM(int PM) {
        this.PM = PM;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public void setPD(int PD) {
        this.PD = PD;
    }

    public boolean estReveille() {
        return etatCourant.peutAttaquer();
        }

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

    public void setDonnees(int PV, int PD) {
        this.PV = PV;
        this.PD = PD;
    }

    public boolean charger() {
        return false;
    }

    public boolean volerVie() {
        return false;
    }

    public boolean encourager() {
        return false;
    }

    public boolean provoquer() {
        return false;
    }

    public boolean isSort() {
        return false;
    }

    public boolean isServiteur() {
        return true;
    }
}
