package effect;

import board.Board;
import carte.Serviteur;
import hero.Hero;
import main.Log;
import service.ServiceGestion;

import java.util.ArrayList;
import java.util.Scanner;

public class BouleFeu implements EffetHeros {

    @Override
    public void activerEffetHeros(Board board, Board boardAdverse, Hero hero) {
        Log.jeu("Qui voulez vous viser ?");
        Log.jeu("1 - Le héros adverse");
        ArrayList<Serviteur> lstServiteurs = boardAdverse.getTerrain().getServiteursTerrain();
        boardAdverse.getTerrain().afficherTerrain();
        int idResult = ServiceGestion.getInputInt(new Scanner(System.in), lstServiteurs.size() + 1);

        if (idResult == 1) {
            boardAdverse.getHero().supprimerPV(1);
            Log.jeu("Le héros adverse a perdu 1PV !");
        } else {
            Serviteur s = boardAdverse.getTerrain().getServiteursTerrain().get(idResult - 2);
            s.supprimerPV(1);
            Log.jeu("Le " + s.toString() + "a perdu 1PV !");
        }
    }

    @Override
    public String toString() {
        return "Boule de feu";
    }
}
