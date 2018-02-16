package card.effect;

import board.Board;
import board.Player;
import card.minion.Minion;
import util.MyLogger;
import util.MyScanner;

import java.util.ArrayList;

public class FireBlast implements EffectHero {

    @Override
    public void activerEffetHeros(Player j, Player jAdversaire) {
        Board boardAdv = jAdversaire.getBoard();
        MyLogger.game("Qui voulez vous viser ?");
        MyLogger.game("1 - Le héros adverse");
        ArrayList<Minion> minions = boardAdv.getServiteursTerrain();
        boardAdv.afficherTerrain();
        int idResult = MyScanner.getInt(new java.util.Scanner(System.in), minions.size() + 1);

        if (idResult == 1) {
            jAdversaire.getHero().supprimerPV(1);
            MyLogger.game("Le héros adverse a perdu 1PV !");
        } else {
            Minion s = boardAdv.getServiteursTerrain().get(idResult - 2);
            s.supprimerPV(1);
            MyLogger.game("Le " + s.toString() + "a perdu 1PV !");
        }
    }

    @Override
    public String toString() {
        return "Boule de feu";
    }
}
