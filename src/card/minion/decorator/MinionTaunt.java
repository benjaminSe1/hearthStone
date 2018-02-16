package card.minion.decorator;

import card.minion.Minion;

public class MinionTaunt extends Minion {
    Minion minion;

    /**
     * Constructeur de la classe MinionTaunt
     * @param minion le minion à décorer
     */
    public MinionTaunt(Minion minion) {
        super(minion);
        this.minion = minion;
    }

    /**
     * Méthode qui permet d'implémenter l'effet provocation
     * @return True car le serviteur possède l'effet provocation
     */
    @Override
    public boolean taunt() {
        super.taunt();
        return true;
    }


}
