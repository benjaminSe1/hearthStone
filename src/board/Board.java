package board;

import java.util.Random;

public class Board {
    private Joueur joueur1;
    private Joueur joueur2;

    public Board(Joueur joueur1, Joueur joueur2) {
        int ordre = this.setFirstHero();
        if (ordre == 0) {
            this.joueur1 = joueur1;
            this.joueur2 = joueur2;
        } else {
            this.joueur1 = joueur2;
            this.joueur2 = joueur1;
        }
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur) {
        this.joueur1 = joueur;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur) {
        this.joueur2 = joueur;
    }

    public int setFirstHero() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

}
