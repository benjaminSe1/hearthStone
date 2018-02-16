package card.minion.decorator;

import card.minion.Minion;

public class MinionLifeSteal extends Minion {
    Minion minion;

    /**
     * Constructeur de la classe MinionLifeSteal
     * @param minion le minion à décorer
     */
    public MinionLifeSteal(Minion minion) {
        super(minion);
        this.minion = minion;
    }

    /**
     * Méthode qui permet d'implémenter l'effet vol de vie
     * @return True car le serviteur possède l'effet vol de vie
     */
    @Override
    public boolean stealLife() {
        super.stealLife();
        return true;
    }

}
