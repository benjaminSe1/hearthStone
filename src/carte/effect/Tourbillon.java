package carte.effect;

import board.Board;
import carte.serviteur.Serviteur;
import main.Log;

public class Tourbillon implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        for (Serviteur s : boardAdverse.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                board.getTerrain().supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        for (Serviteur s : board.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                board.getTerrain().supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        Log.info("Tous les serviteurs ont perdus 1 PV");
    }

}
