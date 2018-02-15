package carte.effect;

import board.Joueur;
import carte.serviteur.Serviteur;
import main.Log;

public class Tourbillon implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        for (Serviteur s : j.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                j.getTerrain().supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        for (Serviteur s : jAdversaire.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                jAdversaire.getTerrain().supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        Log.info("Tous les serviteurs ont perdus 1 PV");
    }

}
