package card.minion.decorator;

import card.minion.Minion;

/**
 * Created by E149769S on 15/02/18.
 */
public abstract class MinionDecorator extends Minion {

    Minion minion;

    public MinionDecorator(Minion minion){
        super(minion);
        this.minion = minion;
    }
}
