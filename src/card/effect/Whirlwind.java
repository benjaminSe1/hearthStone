package card.effect;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

import java.util.ArrayList;
import java.util.Iterator;

public class Whirlwind implements Effect {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        ArrayList<Minion> servTerrainJ = j.getBoard().getServiteursTerrain();
        Iterator<Minion> itJ = servTerrainJ.iterator();
        while (itJ.hasNext()) {
            Minion s = itJ.next();
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                itJ.remove();
                MyLogger.game("Le minion " + s.getNom() + " a été tué");
            }
        }
        j.getBoard().setMinions(servTerrainJ);
        MyLogger.game("Vos minions ont perdu 1 PV");


        ArrayList<Minion> servTerrainAdv = jAdversaire.getBoard().getServiteursTerrain();
        Iterator<Minion> itAdv = servTerrainAdv.iterator();
        while (itAdv.hasNext()) {
            Minion s = itAdv.next();
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                itAdv.remove();
                MyLogger.game("Le minion " + s.getNom() + " a été tué");
            }
        }
        jAdversaire.getBoard().setMinions(servTerrainAdv);
        MyLogger.game("Les minions de votre adversaire ont perdu 1 PV");
    }

}
