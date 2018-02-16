package card.effect;

import board.Player;
import board.Board;
import card.minion.Minion;
import util.MyLogger;
import util.MyScanner;

import java.util.ArrayList;

public class BlessingOfMight implements Effect {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        Board board = j.getBoard();
        MyLogger.game("Veuillez choisir un minion pour lui ajouter 3 points d'attaque");
        ArrayList<Minion> serviteursTerrain = board.getServiteursTerrain();
        if (serviteursTerrain != null) {
            int i = 1;
            for (Minion s : board.getServiteursTerrain()) {
                MyLogger.game(i + " - " + s.toString());
                i++;
            }
            int idServiteur = MyScanner.getInt(new java.util.Scanner(System.in), serviteursTerrain.size());
            Minion s = serviteursTerrain.get(idServiteur-1);
            s.setDonnees(s.getPV(), s.getPD() + 3);
            MyLogger.game("Le minion " + s.getNom() + " a gagné 3 points d'attaque");
        } else {
            MyLogger.game("Ce spell nécessite au moins un minion sur le board");
        }
    }

}
