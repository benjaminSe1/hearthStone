package card.effect;

import java.util.ArrayList;
import java.util.Iterator;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

public class Consecration implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        ArrayList<Minion> boardMinionsOpponent = pOpponent.getBoard().getBoardMinions();
        Iterator<Minion> it = boardMinionsOpponent.iterator();
        while (it.hasNext()) {
            Minion s = it.next();
            s.setData(s.getHP() - 2, s.getDP());
            if (s.getHP() <= 0) {
                it.remove();
                MyLogger.game("Le serviteur " + s.getName() + " a été tué");
            }
        }
        pOpponent.getBoard().setMinions(boardMinionsOpponent);
        MyLogger.game("Les serviteurs adverses ont perdus 2 HP");
    }

}
