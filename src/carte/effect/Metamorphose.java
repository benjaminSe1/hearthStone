package carte.effect;

import java.util.Scanner;

import board.Joueur;
import board.Terrain;
import carte.serviteur.Serviteur;
import main.Log;
import service.ListCartes;
import service.ServiceGestion;

public class Metamorphose implements Effet {

    @Override
    public void activerEffet(Joueur j, Joueur jAdversaire) {
        Log.jeu("Veuillez choisir un serviteur à transformer");
        int i = 1;
        Terrain jAdverse = jAdversaire.getTerrain();
        for (Serviteur s : jAdverse.getServiteursTerrain()) {
            Log.jeu(i + " - " + s.toString());
            i++;
        }
        int idCarte = ServiceGestion.getInputInt(new Scanner(System.in), jAdverse.getServiteursTerrain().size());
        Serviteur s = jAdverse.getServiteursTerrain().get(idCarte);
        jAdverse.supprimerCarte(s);
        jAdverse.ajouterCarte(ListCartes.carteMetamorphose);
        Log.jeu("Le serviteur " + s.getNom() + " a été transformé en serviteur 1/1");

    }


}
