package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateDormir extends State {

    /**
     * Constructeur De la classe StateDormir
     * @param minion Le serviteur
     */
    public StateDormir(Minion minion) {
        super(minion);
    }

    public String toString() {
        return "dort";
    }
}
