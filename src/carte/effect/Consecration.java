package carte.effect;

import board.Board;
import carte.serviteur.Serviteur;
import main.Log;

public class Consecration implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        for (Serviteur s : boardAdverse.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 2, s.getPD());
            if (s.getPV() <= 0) {
                board.getTerrain().supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        Log.info("Les serviteurs adverses ont perdus 2 PV");
    }

}
