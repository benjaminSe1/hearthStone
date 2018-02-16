package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateAttack extends State {
    public StateAttack(Minion minion) {
        super(minion);
    }

    @Override
    public void dormir() {
        minion.changerEtatDormir();
        MyLogger.info("Le minion dort.");
    }

    @Override
    public boolean peutAttaquer() {
        return true;
    }

    public String toString() {
        return "Peut attaquer";
    }
}
