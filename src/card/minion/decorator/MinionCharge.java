package card.minion.decorator;

import card.minion.Minion;

public class MinionCharge extends Minion {

    Minion minion;

    public MinionCharge(Minion minion){
        super(minion);
        this.minion = minion;
        charge();
    }

    @Override
    public boolean charge() {
        this.minion.toStateReady();
        return true;
    }

}
