package card.effect;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

public class ArcaneExplosion implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        for (Minion s : pOpponent.getBoard().getBoardMinions()) {
            s.setData(s.getHP() - 1, s.getDP());
            if (s.getHP() == 0) {
                p.getBoard().removeMinion(s);
                MyLogger.info("Le serviteur " + s.getName() + " a été tué");
            }
        }
        MyLogger.game("Les minions adverses ont perdus 1 PV");
    }

}
