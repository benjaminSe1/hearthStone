package carte.effect;

import board.Joueur;
import carte.serviteur.Serviteur;
import main.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class Tourbillon implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        ArrayList<Serviteur> servTerrainJ = j.getTerrain().getServiteursTerrain();
        Iterator<Serviteur> itJ = servTerrainJ.iterator();
        while (itJ.hasNext()) {
            Serviteur s = itJ.next();
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                itJ.remove();
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        j.getTerrain().setServiteurs(servTerrainJ);
        Log.info("Vos serviteurs ont perdu 1 PV");


        ArrayList<Serviteur> servTerrainAdv = jAdversaire.getTerrain().getServiteursTerrain();
        Iterator<Serviteur> itAdv = servTerrainAdv.iterator();
        while (itAdv.hasNext()) {
            Serviteur s = itAdv.next();
            s.setDonnees(s.getPV() - 1, s.getPD());
            if (s.getPV() <= 0) {
                itAdv.remove();
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        jAdversaire.getTerrain().setServiteurs(servTerrainAdv);
        Log.info("Les serviteurs de votre adversaire ont perdu 1 PV");
    }

}
