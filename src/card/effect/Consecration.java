package card.effect;

import java.util.ArrayList;
import java.util.Iterator;

import board.Player;
import card.minion.Minion;
import util.MyLogger;

public class Consecration implements Effect {

    @Override
    public void activerEffet(Player j, Player jAdversaire) {
        ArrayList<Minion> servTerrain = jAdversaire.getBoard().getServiteursTerrain();
        Iterator<Minion> it = servTerrain.iterator();
        while (it.hasNext()) {
            Minion s = it.next();
            s.setDonnees(s.getPV() - 2, s.getPD());
            if (s.getPV() <= 0) {
                it.remove();
                MyLogger.game("Le minion " + s.getNom() + " a été tué");
            }
        }
        jAdversaire.getBoard().setMinions(servTerrain);
        MyLogger.game("Les minions adverses ont perdus 2 PV");
    }

}
