package board;

import java.util.ArrayList;
import java.util.Random;

import card.Card;
import card.minion.Serviteur;
import card.minion.ServiteurSimple;
import card.spell.Sort;
import hero.Hero;
import util.MyLogger;

public class Player {
    private String pseudo;
    private int ordreJoueur;
    private ArrayList<Card> mainJoueur;
    private Hero hero;
    private Board board;

    public Player(int numero, String pseudo) {
        super();
        this.pseudo = pseudo;
        this.mainJoueur = new ArrayList<>();
        this.board = new Board();
    }


    public String getPseudo() {
        return pseudo;
    }


    public int getOrdreJoueur() {
        return ordreJoueur;
    }

    public void setOrdreJoueur(int ordreJoueur) {
        this.ordreJoueur = ordreJoueur;
    }

    public void initMain(int ordreJoueur) {
        int i = 0;
        if (ordreJoueur == 0) {
            while (i < 3) {
                this.ajouterCarteMain(this.getCartePioche());
                i++;
            }
        } else {
            while (i < 4) {
                this.ajouterCarteMain(this.getCartePioche());
                i++;
            }
        }
    }

    public void ajouterCarteMain(Card card) {
        this.mainJoueur.add(card);
    }

    public void poserCarteMain(Card card) {
        this.mainJoueur.remove(card);
        this.getHero().supprimerPM(card.getPM());
        if (card.isServiteur()) {
            this.getBoard().ajouterCarte((Serviteur) card);
        }
    }

    public ArrayList<Card> getCartesMain() {
        return mainJoueur;
    }

    public String toStringMain() {
        String a = "";
        for (Card c : mainJoueur) {
            a += c.toString() + "\n";
        }
        return a;
    }

    public void afficherCartesMain() {
        int i = 1;
        for (Card c : mainJoueur) {
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public Board getBoard() {
        return board;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Card getCartePioche() {
        ArrayList<Card> cards = this.hero.getCartesHeros();
        Card tmp = cards.get((new Random()).nextInt(cards.size()));

        if (tmp.isServiteur()) {
            Serviteur tympServ = (Serviteur) tmp;
            tmp = new ServiteurSimple(tympServ.getNom(), tympServ.getPM(), tympServ.getPD(), tympServ.getPV());
        } else {
            Sort tmpSort = (Sort) tmp;
            tmp = new Sort(tmpSort.getNom(), tmpSort.getPM(), tmpSort.getEffet());
        }
        return tmp;
    }

    public boolean canPlayCard(Card card) {
        int coutPMCarte = 0;
        coutPMCarte = card.getPM();
        if (coutPMCarte > hero.getPM()) {
            MyLogger.jeu("Vous n'avez pas assez de Point de Mana pour jouer cette card");
            return false;
        }
        return true;
    }

    public boolean canCastHeroicPower() {
        if (hero.getPM() < 2) {
            MyLogger.jeu("Vous n'avez pas assez de Point de Mana pour lancer votre spell");
            return false;
        }
        return true;
    }

}
