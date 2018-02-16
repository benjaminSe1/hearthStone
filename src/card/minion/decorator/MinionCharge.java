package card.minion.decorator;

import card.minion.Minion;

public class MinionCharge extends Minion {

    Minion minion;

    public MinionCharge(Minion minion){
        super(minion.getNom(), minion.getPM(), minion.getPD(), minion.getPV());
        this.minion = minion;
    }

    @Override
    public boolean charger() {
        super.charger();
        return true;
    }

}
