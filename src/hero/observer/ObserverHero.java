package hero.observer;


import util.MyLogger;

public class ObserverHero implements IObserverHero{

    private Sujet heroData;

    private int HP;

    private int AP;

    private int MP;

    public ObserverHero(Sujet heroData) {
        this.heroData = heroData;
        this.heroData.attachObs(this);
    }

    @Override
    public void update(int HP, int AP, int MP) {
        this.HP = HP;
        this.AP = AP;
        this.MP = MP;
        if (this.HP <= 0) {
           MyLogger.jeu("Vous avez gagné");
           System.exit(0);
       }
    }

}
