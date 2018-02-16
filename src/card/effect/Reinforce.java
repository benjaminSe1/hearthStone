package card.effect;

import board.Player;
import util.CardList;
import util.MyLogger;

public class Reinforce implements EffectHero {

    @Override
    public void activateHeroEffect(Player p, Player pOpponent) {
        //Ajoute sur le board allié la card renfort
        p.getBoard().addMinion(CardList.carteRenfort);
        MyLogger.jeu("Un " + CardList.carteRenfort.toString() + "est apparu sur le terrain allié !");
    }

    @Override
    public String toString() {
        return "Reinforce";
    }

}
