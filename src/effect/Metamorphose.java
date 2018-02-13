package effect;

import board.Board;
import carte.Serviteur;
import main.Log;
import service.ListCartes;
import service.ServiceGestion;

import java.util.Scanner;

public class Metamorphose implements Effet {

    @Override
    public void activerEffet(Board board, Board boardAdverse) {
        Log.jeu("Veuillez choisir un serviteur à transformer");
        int i = 1;
        for (Serviteur s : boardAdverse.getTerrain().getServiteursTerrain()) {
            Log.jeu(i + " - " + s.toString());
            i++;
        }
        int idCarte = ServiceGestion.getInputInt(new Scanner(System.in), boardAdverse.getTerrain().getServiteursTerrain().size());
        Serviteur s = boardAdverse.getTerrain().getServiteursTerrain().get(idCarte);
        boardAdverse.getTerrain().supprimerCarte(s);
        boardAdverse.getTerrain().ajouterCarte(ListCartes.carteMetamorphose);
        Log.jeu("Le serviteur " + s.getNom() + " a été transformé en serviteur 1/1");

    }


}
