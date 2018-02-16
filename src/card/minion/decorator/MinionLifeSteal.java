package card.minion.decorator;

import card.minion.Minion;

public class MinionLifeSteal extends Minion {

    Minion minion;

    public MinionLifeSteal(Minion minion){
        super(minion.getNom(), minion.getPM(), minion.getPD(), minion.getPV());
        this.minion = minion;
    }

    @Override
    public boolean volerVie() {
        super.volerVie();
        return true;
    }

}
