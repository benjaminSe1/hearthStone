package observer;

import main.Log;

public class ObserverServiteur implements IObserverServiteur{

    private Sujet donneesServiteur;
    private int PV;
    private int PD;

    public ObserverServiteur(Sujet donneesServiteur){
        this.donneesServiteur = donneesServiteur;
        this.donneesServiteur.enregistrerObs(this);
    }

    @Override
    public void actualiser(int PV, int PD) {
        int restePV = PV - this.PV;
        this.PV = PV;
        this.PD = PD;

        if(restePV > 0){
            Log.jeu("Le serviteur a gagné "+restePV+" PV");
        }
        if(restePV < 0){
            Log.jeu("Le serviteur a perdu "+restePV+" PV");
        }
    }

}
