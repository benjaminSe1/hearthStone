package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateReady extends State {

    /**
     * Constructeur De la classe StateReady
     * @param minion Le serviteur
     */
    public StateReady(Minion minion) {
        super(minion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canAttack() {
        return true;
    }

    public String toString() {
        return "Peut attaquer";
    }
}
