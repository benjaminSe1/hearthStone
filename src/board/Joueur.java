package board;

import carte.Carte;
import main.Log;

import java.util.ArrayList;

public class Joueur {
    private int numero;
    private String pseudo;
    private Board board;
    private int ordreJoueur;
    private ArrayList<Carte> mainJoueur;

    public Joueur(int numero, String pseudo) {
        super();
        this.numero = numero;
        this.pseudo = pseudo;
        this.board = new Board(this);
        this.mainJoueur = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Board getBoard() {
        return board;
    }

    public int getOrdreJoueur() {
        return ordreJoueur;
    }

    public void setOrdreJoueur(int ordreJoueur) {
        this.ordreJoueur = ordreJoueur;
    }

    public void initMain(int a) {
        int i = 0;
        if (a == 0) {
            while (i < 3) {
                this.ajouterCarteMain(this.board.getCartePioche());
                i++;
            }
        } else {
            while (i < 4) {
                this.ajouterCarteMain(this.board.getCartePioche());
                i++;
            }
        }
    }

    public void ajouterCarteMain(Carte uneCarte) {
        this.mainJoueur.add(uneCarte);
    }

    public void poserCarteMain(Carte uneCarte) {
        this.mainJoueur.remove(uneCarte);
    }

    public ArrayList<Carte> getCartesMain() {
        return mainJoueur;
    }

    public String toStringMain() {
        String a = "";
        for (Carte c : mainJoueur) {
            a += c.toString() + "\n";
        }
        return a;
    }

    public void afficherCartesMain() {
        int i = 1;
        for (Carte c : mainJoueur) {
            Log.jeu(i + " - " + c.toString());
            i++;
        }
    }
}
