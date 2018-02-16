package card.minion.decorator;

import card.minion.Minion;

public class MinionEnhanced extends Minion {

    Minion minion;

    public MinionEnhanced(Minion minion){
        super(minion.getName(), minion.getMP(), minion.getDP(), minion.getHP());
        this.minion = minion;

    }
    @Override
    public boolean enhance() {
        super.enhance();
        return true;
    }


}
