package card.effect;

import board.Player;
import util.MyLogger;

public class Armor implements EffectHero {

    @Override
    public void activerEffetHeros(Player j, Player jAdversaire) {
        //Ajoute au héros allié 2 PA
        j.getHero().ajouterPA(2);
        MyLogger.game("Votre héros a maintenant " + j.getHero().getPA() + " points d'armure !");
    }

    @Override
    public String toString() {
        return "Armor";
    }

}
