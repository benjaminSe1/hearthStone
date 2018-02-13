package effect;

import board.Board;
import carte.Carte;
import main.Log;

public class MaitriseBlocage implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        board.getHero().setDonnees(board.getHero().getPV(), board.getHero().getPA() + 5, board.getHero().getPM());
        Carte c = board.getCartePioche();
        board.getJoueur().ajouterCarteMain(c);
        Log.info("Le guerrier a gagné 5 points d'armure. Vous avez pioché une carte");
    }


}
