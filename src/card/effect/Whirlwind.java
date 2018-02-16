package card.effect;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

import java.util.ArrayList;
import java.util.Iterator;

public class Whirlwind implements Effect {

    /**
     * {@inheritDoc}
     * @param p Le joueur qui active l'effet
     * @param pOpponent l'adversaire du jouer p
     */
    @Override
    public void activateEffect(Player p, Player pOpponent) {
        ArrayList<Minion> boardMinions = p.getBoard().getBoardMinions();
        Iterator<Minion> itP = boardMinions.iterator();
        while (itP.hasNext()) {
            Minion s = itP.next();
            s.setData(s.getHP() - 1, s.getDP());
            if (s.getHP() <= 0) {
                itP.remove();
                MyLogger.info("Le serviteur " + s.getName() + " a été tué");
            }
        }
        p.getBoard().setMinions(boardMinions);
        MyLogger.info("Vos serviteurs ont perdu 1 HP");
        ArrayList<Minion> boardOpponentMinions = pOpponent.getBoard().getBoardMinions();
        Iterator<Minion> itPO = boardOpponentMinions.iterator();
        while (itPO.hasNext()) {
            Minion s = itPO.next();
            s.setData(s.getHP() - 1, s.getDP());
            if (s.getHP() <= 0) {
                itPO.remove();
                MyLogger.info("Le serviteur " + s.getName() + " a été tué");
            }
        }
        pOpponent.getBoard().setMinions(boardOpponentMinions);
        MyLogger.game("Les serviteurs de votre adversaire ont perdu 1 HP");
    }

}
