package card.effect;

import board.Player;
import util.MyLogger;
import util.ListCartes;

public class Renfort implements EffetHeros {

    @Override
    public void activerEffetHeros(Player j, Player jAdversaire) {
        //Ajoute sur le board allié la card renfort
        j.getBoard().ajouterCarte(ListCartes.carteRenfort);
        MyLogger.jeu("Un " + ListCartes.carteRenfort.toString() + "est apparu sur le terrain allié !");
    }

    @Override
    public String toString() {
        return "Renfort";
    }

}
