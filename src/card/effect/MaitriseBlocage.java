package card.effect;

import board.Player;
import card.Card;
import hero.Hero;
import util.MyLogger;

public class MaitriseBlocage implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        Hero heroJ = j.getHero();
        heroJ.setDonnees(heroJ.getPV(), heroJ.getPA() + 5, heroJ.getPM());
        Card c = j.getCartePioche();
        j.ajouterCarteMain(c);
        MyLogger.info("Le guerrier a gagné 5 points d'armure. Vous avez pioché une card");
    }


}
