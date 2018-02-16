package card.effect;

import board.Player;
import util.MyLogger;

public class Armor implements EffectHero {

    @Override
    public void activateHeroEffect(Player p, Player pOpponent) {
        //Ajoute au héros allié 2 AP
        p.getHero().addAP(2);
        MyLogger.game("Votre héros a maintenant " + p.getHero().getAP() + " points d'armure !");
    }

    @Override
    public String toString() {
        return "Armor";
    }

}
