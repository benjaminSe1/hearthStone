package card.effect;

import board.Player;
import board.Board;
import card.minion.Serviteur;
import util.MyLogger;
import util.ListCartes;
import util.MyScanner;

public class Metamorphose implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        MyLogger.jeu("Veuillez choisir un minion à transformer");
        int i = 1;
        Board jAdverse = jAdversaire.getBoard();
        for (Serviteur s : jAdverse.getServiteursTerrain()) {
            MyLogger.jeu(i + " - " + s.toString());
            i++;
        }
        int idCarte = MyScanner.getInt(new java.util.Scanner(System.in), jAdverse.getServiteursTerrain().size());
        Serviteur s = jAdverse.getServiteursTerrain().get(idCarte);
        jAdverse.supprimerCarte(s);
        jAdverse.ajouterCarte(ListCartes.carteMetamorphose);
        MyLogger.jeu("Le minion " + s.getNom() + " a été transformé en minion 1/1");

    }


}
