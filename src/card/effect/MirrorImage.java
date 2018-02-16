package card.effect;

import board.Player;
import util.CardList;

public class MirrorImage implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        p.getBoard().addMinion(CardList.carteMiroir);
        p.getBoard().addMinion(CardList.carteMiroir);
    }


}
