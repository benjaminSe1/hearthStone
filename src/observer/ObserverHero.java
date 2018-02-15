package observer;


import main.Log;

public class ObserverHero implements IObserverHero{

    private Sujet donneesHeros;
    private int PV;
    private int PA;
    private int PM;

    public ObserverHero(Sujet donneesHeros){
        this.donneesHeros = donneesHeros;
        this.donneesHeros.enregistrerObs(this);
    }

    @Override
    public void actualiser(int PV, int PA, int PM) {
        this.PV = PV;
        this.PA = PA;
        this.PM = PM;

       if(this.PV <= 0){
           Log.jeu(Sujet.class.getName() + "a perdu");
           System.exit(0);
       }
    }

}
