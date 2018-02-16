package card.effect;

import java.util.ArrayList;

import board.Board;
import board.Player;
import card.minion.Minion;
import util.MyLogger;
import util.MyScanner;

public class FireBlast implements EffectHero {

    @Override
    public void activateHeroEffect(Player p, Player pOpponent) {
        Board opponentBoard = pOpponent.getBoard();
        MyLogger.jeu("Qui voulez vous viser ?");
        MyLogger.jeu("1 - Le héro adverse");
        ArrayList<Minion> opponentMinions = opponentBoard.getBoardMinions();
        opponentBoard.displayBoard();
        int idResult = MyScanner.getInt(new java.util.Scanner(System.in), opponentMinions.size() + 1);

        if (idResult == 1) {
            pOpponent.getHero().removeHP(1);
            MyLogger.jeu("Le héro adverse a perdu 1PV !");
        } else {
            Minion s = opponentBoard.getBoardMinions().get(idResult - 2);
            s.removeHP(1);
            MyLogger.jeu("Le " + s.toString() + "a perdu 1PV !");
        }
    }

    @Override
    public String toString() {
        return "Boule de feu";
    }
}
