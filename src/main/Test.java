package main;

import board.Board;
import board.Joueur;
import carte.Carte;
import carte.serviteur.Serviteur;
import hero.Hero;
import hero.factory.GuerrierFactory;
import hero.factory.HeroFactory;
import service.ListCartes;

import java.util.ArrayList;

public class Test {
    public static void test() {

        Joueur j = new Joueur(1, "pseudo");
        Board board = new Board(j);
        HeroFactory f = new GuerrierFactory();
        Hero h = f.creerHeros();
        board.setHero(h);
        j.getBoard().setHero(h);
        j.initMain(1);
        Log.info(j.toStringMain());


        ArrayList<Carte> lst = ListCartes.cartesPaladin;
        Carte carte = lst.get(5);
        if (carte.isServiteur()) {
            Serviteur s = (Serviteur) carte;
            Log.info(s.charger() + "");
            Log.info(s.encourager() + "");
        }
    }
}
