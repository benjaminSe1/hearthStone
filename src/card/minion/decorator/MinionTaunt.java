package card.minion.decorator;

import card.minion.Minion;

public class MinionTaunt extends Minion {

    Minion minion;

    public MinionTaunt(Minion minion){
        super(minion);
        this.minion = minion;
    }

    @Override
    public boolean taunt() {
        super.taunt();
        return true;
    }


}
