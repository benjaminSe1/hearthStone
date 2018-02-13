package carte.effect;

import board.Board;
import hero.Hero;
import main.Log;
import service.ListCartes;

public class Renfort implements EffetHeros {

    @Override
    public void activerEffetHeros(Board board, Board boardAdverse, Hero hero) {
        //Ajoute sur le board allié la carte renfort
        board.getTerrain().ajouterCarte(ListCartes.carteRenfort);
        Log.jeu("Un " + ListCartes.carteRenfort.toString() + "est apparu sur le terrain allié !");
    }

    @Override
    public String toString() {
        return "Renfort";
    }

}
