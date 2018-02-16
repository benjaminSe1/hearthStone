package card.effect;

import board.Board;
import board.Player;
import card.minion.Minion;
import util.CardList;
import util.MyLogger;
import util.MyScanner;

public class Polymorph implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        MyLogger.jeu("Veuillez choisir un serviteur à transformer");
        int i = 1;
        Board opponentBoard = pOpponent.getBoard();
        for (Minion s : opponentBoard.getBoardMinions()) {
            MyLogger.jeu(i + " - " + s.toString());
            i++;
        }
        int idCard = MyScanner.getInt(new java.util.Scanner(System.in), opponentBoard.getBoardMinions().size());
        Minion s = opponentBoard.getBoardMinions().get(idCard);
        opponentBoard.removeMinion(s);
        opponentBoard.addMinion(CardList.carteMetamorphose);
        MyLogger.jeu("Le serviteur " + s.getName() + " a été transformé en minion 1/1");

    }


}
