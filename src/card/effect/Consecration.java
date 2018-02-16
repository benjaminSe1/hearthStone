package card.effect;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

import java.util.ArrayList;
import java.util.Iterator;

public class Consecration implements Effect {

    /**
     * {@inheritDoc}
     * @param p Le joueur qui active l'effet
     * @param pOpponent l'adversaire du jouer p
     */
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
