package card.effect;

import board.Player;
import card.CardList;
import util.MyLogger;

public class Reinforce implements EffectHero {

    /**
     * {@inheritDoc}
     * @param p le hero qui active son pouvoir
     * @param pOpponent l'adversaire du héro p
     */
    @Override
    public void activateHeroEffect(Player p, Player pOpponent) {
        //Ajoute sur le board allié la carte renfort
        p.getBoard().addMinion(CardList.silverHandRecruit);
        MyLogger.game("Un " + CardList.silverHandRecruit.toString() + "est apparu sur le terrain allié !");
    }

    @Override
    public String toString() {
        return "Renforcer";
    }

}
