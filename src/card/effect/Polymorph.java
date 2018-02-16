package card.effect;

import board.Player;
import board.Board;
import card.minion.Minion;
import util.MyLogger;
import util.CardList;
import util.MyScanner;

public class Polymorph implements Effect {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        MyLogger.jeu("Veuillez choisir un minion à transformer");
        int i = 1;
        Board jAdverse = jAdversaire.getBoard();
        for (Minion s : jAdverse.getServiteursTerrain()) {
            MyLogger.jeu(i + " - " + s.toString());
            i++;
        }
        int idCarte = MyScanner.getInt(new java.util.Scanner(System.in), jAdverse.getServiteursTerrain().size());
        Minion s = jAdverse.getServiteursTerrain().get(idCarte);
        jAdverse.supprimerCarte(s);
        jAdverse.ajouterCarte(CardList.carteMetamorphose);
        MyLogger.jeu("Le minion " + s.getNom() + " a été transformé en minion 1/1");

    }


}
