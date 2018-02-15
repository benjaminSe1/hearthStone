package carte.effect;

import board.Board;
import carte.Carte;
import carte.serviteur.Serviteur;
import main.Log;
import service.ServiceGestion;

import java.util.ArrayList;
import java.util.Scanner;

public class BenedictionPuissance implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        Log.jeu("Veuillez choisir un serviteur pour lui ajouter 3 points d'attaque");
        if(board.getTerrain().getServiteursTerrain() != null) {
            int i = 1;
            for (Serviteur s : board.getTerrain().getServiteursTerrain()) {
                Log.jeu(i + " - " + s.toString());
                i++;
            }
            int idServiteur = ServiceGestion.getInputInt(new Scanner(System.in), board.getTerrain().getServiteursTerrain().size());
            Serviteur s = board.getTerrain().getServiteursTerrain().get(idServiteur);
            s.setDonnees(s.getPV(), s.getPD() + 3);
            Log.jeu("Le serviteur " + s.getNom() + " a gagné 3 points d'attaque");
        }else{
            Log.jeu("Ce sort nécessite au moins un serviteur sur le terrain");
        }
    }

}
