package card.effect;

import board.Player;
import util.CardList;

public class MirrorImage implements Effect {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        j.getBoard().ajouterCarte(CardList.carteMiroir);
        j.getBoard().ajouterCarte(CardList.carteMiroir);
    }


}
