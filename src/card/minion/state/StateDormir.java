package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateDormir extends State {

    public StateDormir(Minion minion) {
        super(minion);
    }

    @Override
    public void attack() {
        minion.toStateReady();
        MyLogger.info("Le serviteur peut attaquer");
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    public String toString() {
        return "dort";
    }
}
