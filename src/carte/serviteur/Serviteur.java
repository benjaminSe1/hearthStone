package carte.serviteur;

import carte.Carte;
import observer.Observer;

public interface Serviteur extends Carte {

    int getPV();

    int getPD();

    int getPM();

    String getNom();

    String toString();

    void supprimerPV(int PV);

    void ajouterPV(int PV);

    void supprimerPD(int PD);

    void ajouterPD(int PD);

    void changerEtatAttaquer();

    void changerEtatDormir();

    void enregistrerObs(Observer o);

    void supprimerObs(Observer o);

    void notifierObs();

    void setDonnees(int PV, int PD);

    boolean charger();

    boolean volerVie();

    boolean encourager();

    boolean provoquer();

    boolean estReveille();

}
