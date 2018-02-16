package card.minion.state;

import card.minion.Minion;
import util.MyLogger;

public class StateDormir extends State {

    public StateDormir(Minion minion) {
        super(minion);
    }

    @Override
    public void attaquer() {
        minion.changerEtatAttaquer();
        MyLogger.game("Le minion peut attaquer");
    }

    @Override
    public boolean peutAttaquer() {
        return false;
    }

    public String toString() {
        return "dort";
    }
}
