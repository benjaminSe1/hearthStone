package card.effect;

import java.util.ArrayList;
import java.util.Iterator;

import board.Player;
import card.minion.Serviteur;
import util.MyLogger;

public class Consecration implements Effet {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        ArrayList<Serviteur> servTerrain = jAdversaire.getBoard().getServiteursTerrain();
        Iterator<Serviteur> it = servTerrain.iterator();
        while (it.hasNext()) {
            Serviteur s = it.next();
            s.setDonnees(s.getPV() - 2, s.getPD());
            if (s.getPV() <= 0) {
                it.remove();
                MyLogger.info("Le minion " + s.getNom() + " a été tué");
            }
        }
        jAdversaire.getBoard().setServiteurs(servTerrain);
        MyLogger.info("Les serviteurs adverses ont perdus 2 PV");
    }

}
