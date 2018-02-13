package effect;

import board.Board;
import service.ListCartes;

public class ImageMiroir implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        board.getTerrain().ajouterCarte(ListCartes.carteMiroir);
        board.getTerrain().ajouterCarte(ListCartes.carteMiroir);
    }


}
