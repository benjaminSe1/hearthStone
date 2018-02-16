package card.minion.decorator;

import card.minion.Minion;

public class MinionEnhanced extends Minion {

    Minion minion;

    /**
     * Constructeur de la classe MinionEnhanced
     * @param minion le minion à décorer
     */
    public MinionEnhanced(Minion minion) {
        super(minion);
        this.minion = minion;

    }

    /**
     * Méthode qui permet d'implémenter l'effet encourrage
     * @return True car le serviteur possède l'effet encourrage
     */
    @Override
    public boolean enhance() {
        super.enhance();
        return true;
    }


}
