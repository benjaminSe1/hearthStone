package carte.effect;

import board.Joueur;
import carte.serviteur.Serviteur;
import main.Log;

public class Consecration implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        for (Serviteur s : jAdversaire.getTerrain().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 2, s.getPD());
            if (s.getPV() <= 0) {
                j.getTerrain().supprimerCarte(s);
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        Log.info("Les serviteurs adverses ont perdus 2 PV");
    }

}
