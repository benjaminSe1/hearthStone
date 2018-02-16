package card.effect;

import board.Player;
import board.Board;
import card.minion.Serviteur;
import util.MyLogger;
import util.MyScanner;

import java.util.ArrayList;

public class BenedictionPuissance implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        Board board = j.getBoard();
        MyLogger.jeu("Veuillez choisir un minion pour lui ajouter 3 points d'attaque");
        ArrayList<Serviteur> serviteursTerrain = board.getServiteursTerrain();
        if (serviteursTerrain != null) {
            int i = 1;
            for (Serviteur s : board.getServiteursTerrain()) {
                MyLogger.jeu(i + " - " + s.toString());
                i++;
            }
            int idServiteur = MyScanner.getInt(new java.util.Scanner(System.in), serviteursTerrain.size());
            Serviteur s = serviteursTerrain.get(idServiteur-1);
            s.setDonnees(s.getPV(), s.getPD() + 3);
            MyLogger.jeu("Le minion " + s.getNom() + " a gagné 3 points d'attaque");
        } else {
            MyLogger.jeu("Ce spell nécessite au moins un minion sur le board");
        }
    }

}
