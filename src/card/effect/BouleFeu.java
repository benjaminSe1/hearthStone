package card.effect;

import board.Board;
import board.Player;
import card.minion.Serviteur;
import util.MyLogger;
import util.MyScanner;

import java.util.ArrayList;

public class BouleFeu implements EffetHeros {

    @Override
    public void activerEffetHeros(Player j, Player jAdversaire) {
        Board boardAdv = jAdversaire.getBoard();
        MyLogger.jeu("Qui voulez vous viser ?");
        MyLogger.jeu("1 - Le héros adverse");
        ArrayList<Serviteur> lstServiteurs = boardAdv.getServiteursTerrain();
        boardAdv.afficherTerrain();
        int idResult = MyScanner.getInt(new java.util.Scanner(System.in), lstServiteurs.size() + 1);

        if (idResult == 1) {
            jAdversaire.getHero().supprimerPV(1);
            MyLogger.jeu("Le héros adverse a perdu 1PV !");
        } else {
            Serviteur s = boardAdv.getServiteursTerrain().get(idResult - 2);
            s.supprimerPV(1);
            MyLogger.jeu("Le " + s.toString() + "a perdu 1PV !");
        }
    }

    @Override
    public String toString() {
        return "Boule de feu";
    }
}
