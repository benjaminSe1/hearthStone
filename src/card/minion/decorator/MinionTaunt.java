package card.minion.decorator;

import card.minion.Minion;

public class MinionTaunt extends Minion {

    Minion minion;

    public MinionTaunt(Minion minion){
        super(minion.getNom(), minion.getPM(), minion.getPD(), minion.getPV());
        this.minion = minion;
    }

    @Override
    public boolean provoquer() {
        super.provoquer();
        return true;
    }


}
