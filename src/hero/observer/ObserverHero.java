package hero.observer;


import util.MyLogger;

public class ObserverHero implements IObserverHero {

    private Sujet heroData;

    private int HP;

    private int AP;

    private int MP;

    /**
     * Permet d'enregistrer un observer sur un Hero
     * @param heroData - Le Hero
     */
    public ObserverHero(Sujet heroData) {
        this.heroData = heroData;
        this.heroData.attachObs(this);
    }

    /**
     * Permet de mettre à jour les informations d'un Hero
     * @param HP - Les points de vie du Hero
     * @param AP - Les points d'armure du Hero
     * @param MP - Les points de mana du Hero
     */
    @Override
    public void update(int HP, int AP, int MP) {
        this.HP = HP;
        this.AP = AP;
        this.MP = MP;
        if (this.HP <= 0) {
            MyLogger.game("Vous avez gagné");
            System.exit(0);
        }
    }

}
