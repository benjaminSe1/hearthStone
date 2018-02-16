package card.effect;

import board.Player;
import card.CardList;

public class MirrorImage implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        p.getBoard().addMinion(CardList.mirrorImage);
        p.getBoard().addMinion(CardList.mirrorImage);
    }


}
