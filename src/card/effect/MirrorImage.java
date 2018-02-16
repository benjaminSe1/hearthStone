package card.effect;

import board.Player;
import card.CardList;

public class MirrorImage implements Effect {

    /**
     * {@inheritDoc}
     * @param p Le joueur qui active l'effet
     * @param pOpponent l'adversaire du jouer p
     */
    @Override
    public void activateEffect(Player p, Player pOpponent) {
        p.getBoard().addMinion(CardList.mirrorImage);
        p.getBoard().addMinion(CardList.mirrorImage);
    }


}
