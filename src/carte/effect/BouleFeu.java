package carte.effect;

import board.Joueur;
import board.Terrain;
import carte.serviteur.Serviteur;
import main.Log;
import service.ServiceGestion;

import java.util.ArrayList;
import java.util.Scanner;

public class BouleFeu implements EffetHeros {

    @Override
    public void activerEffetHeros(Joueur j, Joueur jAdversaire) {
        Terrain terrainAdv = jAdversaire.getTerrain();
        Log.jeu("Qui voulez vous viser ?");
        Log.jeu("1 - Le héros adverse");
        ArrayList<Serviteur> lstServiteurs = terrainAdv.getServiteursTerrain();
        terrainAdv.afficherTerrain();
        int idResult = ServiceGestion.getInputInt(new Scanner(System.in), lstServiteurs.size() + 1);

        if (idResult == 1) {
            jAdversaire.getHero().supprimerPV(1);
            Log.jeu("Le héros adverse a perdu 1PV !");
        } else {
            Serviteur s = terrainAdv.getServiteursTerrain().get(idResult - 2);
            s.supprimerPV(1);
            Log.jeu("Le " + s.toString() + "a perdu 1PV !");
        }
    }

    @Override
    public String toString() {
        return "Boule de feu";
    }
}
