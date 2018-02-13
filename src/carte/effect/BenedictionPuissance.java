package carte.effect;

import board.Board;
import carte.serviteur.Serviteur;
import main.Log;
import service.ServiceGestion;

import java.util.Scanner;

public class BenedictionPuissance implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        Log.jeu("Veuillez choisir un serviteur pour lui ajouter 3 points d'attaque");
        int i = 1;
        for (Serviteur s : board.getTerrain().getServiteursTerrain()) {
            Log.jeu(i + " - " + s.toString());
            i++;
        }
        int idServiteur = ServiceGestion.getInputInt(new Scanner(System.in), board.getTerrain().getServiteursTerrain().size());
        Serviteur s = board.getTerrain().getServiteursTerrain().get(idServiteur);
        s.setDonnees(s.getPV(), s.getPD() + 3);
        Log.jeu("Le serviteur " + s.getNom() + " a gagné 3 points d'attaque");
    }

}
