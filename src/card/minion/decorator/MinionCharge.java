package card.minion.decorator;

import card.minion.Minion;

public class MinionCharge extends Minion {

    Minion minion;

    public MinionCharge(Minion minion){
        super(minion.getName(), minion.getMP(), minion.getDP(), minion.getHP());
        this.minion = minion;
    }

    @Override
    public boolean charge() {
        super.charge();
        return true;
    }

}
