package decorator;

import carte.Serviteur;
import observer.Observer;

public class ServiteurDecorator implements Serviteur {
    private Serviteur serviteur;

    public ServiteurDecorator(Serviteur s) {
        this.serviteur = s;
    }

    @Override
    public int getPV() {
        return serviteur.getPV();
    }

    @Override
    public int getPD() {
        return serviteur.getPD();
    }

    @Override
    public int getPM() {
        return serviteur.getPM();
    }

    @Override
    public String getNom() {
        return serviteur.getNom();
    }

    @Override
    public String toString() {
        return serviteur.toString();
    }

    @Override
    public void changerEtatAttaquer() {
        serviteur.changerEtatAttaquer();
    }

    @Override
    public void changerEtatDormir() {
        serviteur.changerEtatDormir();
    }

    @Override
    public void enregistrerObs(Observer o) {
        serviteur.enregistrerObs(o);
    }

    @Override
    public void supprimerObs(Observer o) {
        serviteur.supprimerObs(o);
    }

    @Override
    public void notifierObs() {
        serviteur.notifierObs();
    }

    @Override
    public void setDonnees(int PV, int PD) {
        serviteur.setDonnees(PV, PD);
    }

    @Override
    public boolean charger() {
        return this.serviteur.charger();

    }

    @Override
    public boolean volerVie() {
        return this.serviteur.volerVie();

    }

    @Override
    public boolean encourager() {
        return this.serviteur.encourager();

    }

    @Override
    public boolean provoquer() {
        return this.serviteur.provoquer();

    }

    @Override
    public boolean isSort() {
        return serviteur.isSort();
    }

    @Override
    public boolean isServiteur() {
        return serviteur.isServiteur();
    }

    @Override
    public void supprimerPV(int PV) {
        serviteur.supprimerPV(PV);

    }

    @Override
    public void ajouterPV(int PV) {
        serviteur.ajouterPV(PV);

    }

    @Override
    public void supprimerPD(int PD) {
        serviteur.supprimerPD(PD);

    }

    @Override
    public void ajouterPD(int PD) {
        serviteur.ajouterPD(PD);

    }

    @Override
    public boolean estReveille() {
        return serviteur.estReveille();
    }

}
