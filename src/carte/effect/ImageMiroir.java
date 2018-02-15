package carte.effect;

import board.Joueur;
import service.ListCartes;

public class ImageMiroir implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        j.getTerrain().ajouterCarte(ListCartes.carteMiroir);
        j.getTerrain().ajouterCarte(ListCartes.carteMiroir);
    }


}
