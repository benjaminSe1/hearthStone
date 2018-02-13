package board;

import carte.Carte;
import hero.Hero;
import main.Log;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private Terrain terrain;
    private Hero hero;
    private Joueur joueur;

    public Board(Joueur j) {
        this.terrain = new Terrain();
        this.joueur = j;
    }


    public Terrain getTerrain() {
        return terrain;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Carte getCartePioche() {
        ArrayList<Carte> lesCartes = this.hero.getCartesHeros();
        return lesCartes.get((new Random()).nextInt(lesCartes.size()));
    }

    public boolean canPlayCard(Carte carte) {
        int coutPMCarte = 0;
        /* av2bsee

        if (carte.isServiteur()) {
            Serviteur serviteur = (Serviteur) carte;
            coutPMCarte = serviteur.getPM();
        }
        if (carte.isSort()) {
            Sort sort = (Sort) carte;
            coutPMCarte = sort.getPM();
        }*/
        coutPMCarte = carte.getPM();
        if (coutPMCarte > hero.getPM()) {
            Log.jeu("Vous n'avez pas assez de Point de Mana pour jouer cette carte");
            return false;
        }
        return true;
    }

    public boolean canCastHeroicPower() {
        if (hero.getPM() < 2) {
            Log.jeu("Vous n'avez pas assez de Point de Mana pour lancer votre sort");
            return false;
        }
        return true;
    }

    public Joueur getJoueur(){
        return joueur;
    }
}