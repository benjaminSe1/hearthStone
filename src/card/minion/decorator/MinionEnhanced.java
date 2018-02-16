package card.minion.decorator;

import card.minion.Minion;

public class MinionEnhanced extends Minion {

    Minion minion;

    public MinionEnhanced(Minion minion){
        super(minion.getNom(), minion.getPM(), minion.getPD(), minion.getPV());
        this.minion = minion;

    }
    @Override
    public boolean encourager() {
        super.encourager();
        return true;
    }


}
