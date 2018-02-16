package card.effect;

import board.Player;
import board.Board;
import card.minion.Minion;
import util.MyLogger;
import util.CardList;
import util.MyScanner;

public class Polymorph implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        MyLogger.game("Veuillez choisir un serviteur à transformer");
        int i = 1;
        Board opponentBoard = pOpponent.getBoard();
        for (Minion s : opponentBoard.getBoardMinions()) {
            MyLogger.game(i + " - " + s.toString());
            i++;
        }
        int idCard = MyScanner.getInt(new java.util.Scanner(System.in), opponentBoard.getBoardMinions().size());
        Minion s = opponentBoard.getBoardMinions().get(idCard);
        opponentBoard.removeMinion(s);
        opponentBoard.addMinion(CardList.sheep);
        MyLogger.game("Le serviteur " + s.getName() + " a été transformé en minion 1/1");

    }


}
