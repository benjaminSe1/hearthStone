package carte.effect;

import board.Joueur;
import carte.Carte;
import hero.Hero;
import main.Log;

public class MaitriseBlocage implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        Hero heroJ = j.getHero();
        heroJ.setDonnees(heroJ.getPV(), heroJ.getPA() + 5, heroJ.getPM());
        Carte c = j.getCartePioche();
        j.ajouterCarteMain(c);
        Log.info("Le guerrier a gagné 5 points d'armure. Vous avez pioché une carte");
    }


}
