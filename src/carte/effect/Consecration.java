package carte.effect;

import java.util.ArrayList;
import java.util.Iterator;

import board.Joueur;
import carte.serviteur.Serviteur;
import main.Log;

public class Consecration implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        ArrayList<Serviteur>  servTerrain = jAdversaire.getTerrain().getServiteursTerrain();
        Iterator<Serviteur> it = servTerrain.iterator();
        while(it.hasNext()){
            Serviteur s = it.next();
            s.setDonnees(s.getPV() - 2, s.getPD());
            if (s.getPV() <= 0) {
                it.remove();
                Log.info("Le serviteur " + s.getNom() + " a été tué");
            }
        }
        jAdversaire.getTerrain().setServiteurs(servTerrain);
        Log.info("Les serviteurs adverses ont perdus 2 PV");
    }

}
