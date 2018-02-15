package carte.effect;

import board.Joueur;
import main.Log;
import service.ListCartes;

public class Renfort implements EffetHeros {

    @Override
    public void activerEffetHeros(Joueur j, Joueur jAdversaire) {
        //Ajoute sur le board allié la carte renfort
        j.getTerrain().ajouterCarte(ListCartes.carteRenfort);
        Log.jeu("Un " + ListCartes.carteRenfort.toString() + "est apparu sur le terrain allié !");
    }

    @Override
    public String toString() {
        return "Renfort";
    }

}
