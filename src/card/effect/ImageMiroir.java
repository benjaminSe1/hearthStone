package card.effect;

import board.Player;
import util.ListCartes;

public class ImageMiroir implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        j.getBoard().ajouterCarte(ListCartes.carteMiroir);
        j.getBoard().ajouterCarte(ListCartes.carteMiroir);
    }


}
