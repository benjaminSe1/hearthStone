package carte.effect;

import board.Joueur;
import hero.Hero;
import main.Log;

public class Armure implements EffetHeros {

    @Override
    public void activerEffetHeros(Joueur j, Joueur jAdversaire) {
        //Ajoute au héros allié 2 PA
        j.getHero().ajouterPA(2);
        Log.jeu("Votre héros a maintenant " + j.getHero().getPA() + " points d'armure !");
    }

    @Override
    public String toString() {
        return "Armure";
    }

}
