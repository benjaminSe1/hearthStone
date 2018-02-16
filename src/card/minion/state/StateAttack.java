package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateAttack extends State {
    public StateAttack(Minion minion) {
        super(minion);
    }

    @Override
    public void sleep() {
        minion.toSleepState();
        MyLogger.info("Le serviteur dort.");
    }

    @Override
    public boolean canAttack() {
        return true;
    }

    public String toString() {
        return "Peut attack";
    }
}
