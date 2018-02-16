package card.minion.decorator;

import card.minion.Minion;

public abstract class MinionDecorator extends Minion {
    Minion minion;

    /**
     * Constructeur de la classe MinionDecorator
     * @param minion le minion à décorer
     */
    public MinionDecorator(Minion minion) {
        super(minion);
        this.minion = minion;
    }
}
