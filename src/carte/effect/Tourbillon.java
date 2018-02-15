package carte.effect;

import board.Joueur;
import board.Terrain;
import carte.serviteur.Serviteur;
import main.Log;

public class Tourbillon implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        Terrain tAdv = jAdversaire.getTerrain();
        for (Serviteur s : jAdversaire.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                tAdv.supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        for (Serviteur s : tAdv.getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                tAdv.supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        Log.info("Tous les serviteurs ont perdus 1 PV");
    }

}
