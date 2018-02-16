package card.minion.decorator;

import card.minion.Minion;

public class MinionLifeSteal extends Minion {

    Minion minion;

    public MinionLifeSteal(Minion minion) {
        super(minion);
        this.minion = minion;
    }

    @Override
    public boolean stealLife() {
        super.stealLife();
        return true;
    }

}
