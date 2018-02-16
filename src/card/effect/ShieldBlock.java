package card.effect;

import board.Player;
import card.Card;
import hero.Hero;
import util.MyLogger;

public class ShieldBlock implements Effect {

    @Override
    public void activateEffect(Player p, Player pOpponent) {
        Hero heroJ = p.getHero();
        heroJ.setData(heroJ.getHP(), heroJ.getAP() + 5, heroJ.getMP());
        Card c = p.getDraw();
        p.addCardHand(c);
        MyLogger.info("Le guerrier a gagné 5 points d'armure. Vous avez pioché une card");
    }


}
