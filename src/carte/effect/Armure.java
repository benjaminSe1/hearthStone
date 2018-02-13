package carte.effect;

import board.Board;
import hero.Hero;
import main.Log;

public class Armure implements EffetHeros {

    @Override
    public void activerEffetHeros(Board board, Board boardAdverse, Hero hero) {
        //Ajoute au héros allié 2 PA
        hero.ajouterPA(2);
        Log.jeu("Votre héros a maintenant " + hero.getPA() + " points d'armure !");
    }

    @Override
    public String toString() {
        return "Armure";
    }

}
