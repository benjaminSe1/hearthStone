package card.effect;

import board.Board;
import board.Player;
import card.minion.Minion;
import util.MyLogger;
import util.MyScanner;

import java.util.ArrayList;

public class BlessingOfMight implements Effect {

    /**
     * {@inheritDoc}
     * @param p Le joueur qui active l'effet
     * @param pOpponent l'adversaire du jouer p
     */
    @Override
    public void activateEffect(Player p, Player pOpponent) {
        Board board = p.getBoard();
        MyLogger.game("Veuillez choisir un serviteur pour lui ajouter 3 points d'attaque");
        ArrayList<Minion> boardMinions = board.getBoardMinions();
        if (boardMinions != null) {
            int i = 1;
            for (Minion s : board.getBoardMinions()) {
                MyLogger.game(i + " - " + s.toString());
                i++;
            }
            int idMinion = MyScanner.getInt(new java.util.Scanner(System.in), boardMinions.size());
            Minion s = boardMinions.get(idMinion - 1);
            s.setData(s.getHP(), s.getDP() + 3);
            MyLogger.game("Le serviteur " + s.getName() + " a gagné 3 points d'attaque");
        } else {
            MyLogger.game("Ce sort nécessite au moins un serviteur sur le board");
        }
    }

}
