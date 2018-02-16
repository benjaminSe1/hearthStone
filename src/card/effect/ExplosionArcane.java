package card.effect;

import board.Player;
import card.minion.Serviteur;
import util.MyLogger;

public class ExplosionArcane implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        for (Serviteur s : jAdversaire.getBoard().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                j.getBoard().supprimerCarte(s);
                MyLogger.info("Le minion " + s.getNom() + " a été tué");
            }
        }
        MyLogger.info("Les serviteurs adverses ont perdus 1 PV");
    }

}
