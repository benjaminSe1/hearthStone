package carte;

import observer.Observer;

public interface Serviteur extends Carte {

    public int getPV();

    public int getPD();

    public int getPM();

    public String getNom();

    public String toString();

    public void supprimerPV(int PV);

    public void ajouterPV(int PV);

    public void supprimerPD(int PD);

    public void ajouterPD(int PD);

    public void changerEtatAttaquer();

    public void changerEtatDormir();

    public void enregistrerObs(Observer o);

    public void supprimerObs(Observer o);

    public void notifierObs();

    public void setDonnees(int PV, int PD);

    public boolean charger();

    public boolean volerVie();

    public boolean encourager();

    public boolean provoquer();

    public boolean estReveille();

}
