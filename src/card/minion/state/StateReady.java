package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateReady extends State {

    public StateReady(Minion minion) {
        super(minion);
    }

    @Override
    public void sleep() {
        minion.toStateSleep();
        MyLogger.info("Le serviteur dort.");
    }

    @Override
    public boolean canAttack() {
        return true;
    }

    public String toString() {
        return "Peut attaquer";
    }
}
