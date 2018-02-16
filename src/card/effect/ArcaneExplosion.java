package card.effect;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

public class ArcaneExplosion implements Effect {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        for (Minion s : jAdversaire.getBoard().getServiteursTerrain()) {
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() == 0) {
                j.getBoard().supprimerCarte(s);
                MyLogger.info("Le minion " + s.getNom() + " a été tué");
            }
        }
        MyLogger.info("Les minions adverses ont perdus 1 PV");
    }

}
