package carte.effect;

import board.Joueur;
import board.Terrain;
import carte.serviteur.Serviteur;
import main.Log;
import service.MyScanner;

import java.util.ArrayList;

public class BenedictionPuissance implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        Terrain terrain = j.getTerrain();
        Log.jeu("Veuillez choisir un serviteur pour lui ajouter 3 points d'attaque");
        ArrayList<Serviteur> serviteursTerrain = terrain.getServiteursTerrain();
        if (serviteursTerrain != null) {
            int i = 1;
            for (Serviteur s : terrain.getServiteursTerrain()) {
                Log.jeu(i + " - " + s.toString());
                i++;
            }
            int idServiteur = MyScanner.getInt(new java.util.Scanner(System.in), serviteursTerrain.size());
            Serviteur s = serviteursTerrain.get(idServiteur-1);
            s.setDonnees(s.getPV(), s.getPD() + 3);
            Log.jeu("Le serviteur " + s.getNom() + " a gagné 3 points d'attaque");
        } else {
            Log.jeu("Ce sort nécessite au moins un serviteur sur le terrain");
        }
    }

}
