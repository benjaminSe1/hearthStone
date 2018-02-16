package card.effect;

import board.Player;
import card.minion.Serviteur;
import util.MyLogger;

import java.util.ArrayList;
import java.util.Iterator;

public class Tourbillon implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        ArrayList<Serviteur> servTerrainJ = j.getBoard().getServiteursTerrain();
        Iterator<Serviteur> itJ = servTerrainJ.iterator();
        while (itJ.hasNext()) {
            Serviteur s = itJ.next();
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                itJ.remove();
                MyLogger.info("Le minion " + s.getNom() + " a été tué");
            }
        }
        j.getBoard().setServiteurs(servTerrainJ);
        MyLogger.info("Vos serviteurs ont perdu 1 PV");


        ArrayList<Serviteur> servTerrainAdv = jAdversaire.getBoard().getServiteursTerrain();
        Iterator<Serviteur> itAdv = servTerrainAdv.iterator();
        while (itAdv.hasNext()) {
            Serviteur s = itAdv.next();
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                itAdv.remove();
                MyLogger.info("Le minion " + s.getNom() + " a été tué");
            }
        }
        jAdversaire.getBoard().setServiteurs(servTerrainAdv);
        MyLogger.info("Les serviteurs de votre adversaire ont perdu 1 PV");
    }

}
