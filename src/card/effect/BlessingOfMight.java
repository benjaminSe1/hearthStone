package card.effect;

import java.util.ArrayList;

import board.Board;
import board.Player;
import card.minion.Minion;
import util.MyLogger;
import util.MyScanner;

public class BlessingOfMight implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        Board board = p.getBoard();
        MyLogger.jeu("Veuillez choisir un serviteur pour lui ajouter 3 points d'attaque");
        ArrayList<Minion> boardMinions = board.getBoardMinions();
        if (boardMinions != null) {
            int i = 1;
            for (Minion s : board.getBoardMinions()) {
                MyLogger.jeu(i + " - " + s.toString());
                i++;
            }
            int idMinion = MyScanner.getInt(new java.util.Scanner(System.in), boardMinions.size());
            Minion s = boardMinions.get(idMinion - 1);
            s.setData(s.getHP(), s.getDP() + 3);
            MyLogger.jeu("Le serviteur " + s.getName() + " a gagné 3 points d'attaque");
        } else {
            MyLogger.jeu("Ce spell nécessite au moins un serviteur sur le board");
        }
    }

}
