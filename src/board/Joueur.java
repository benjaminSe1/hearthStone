package board;

import java.util.ArrayList;
import java.util.Random;

import carte.Carte;
import carte.serviteur.Serviteur;
import carte.serviteur.ServiteurSimple;
import carte.sort.Sort;
import hero.Hero;
import main.Log;

public class Joueur {
    private String pseudo;
    private int ordreJoueur;
    private ArrayList<Carte> mainJoueur;
    private Hero hero;
    private Terrain terrain;

    public Joueur(int numero, String pseudo) {
        super();
        this.pseudo = pseudo;
        this.mainJoueur = new ArrayList<>();
        this.terrain = new Terrain();
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

    public void initMain(int a) {
        int i = 0;
        if (a == 0) {
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

    public void ajouterCarteMain(Carte uneCarte) {
        this.mainJoueur.add(uneCarte);
    }

    public void poserCarteMain(Carte uneCarte) {
        this.mainJoueur.remove(uneCarte);
        this.getHero().supprimerPM(uneCarte.getPM());
        if(uneCarte.isServiteur()){
            this.getTerrain().ajouterCarte((Serviteur) uneCarte);
        }
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
        Carte tmp = lesCartes.get((new Random()).nextInt(lesCartes.size()));

        if(tmp.isServiteur()){
            Serviteur tympServ = (Serviteur) tmp;
            tmp = new ServiteurSimple(tympServ.getNom(), tympServ.getPM(), tympServ.getPD(), tympServ.getPV());
        }else{
            Sort tmpSort = (Sort) tmp;
            tmp = new Sort(tmpSort.getNom(), tmpSort.getPM(), tmpSort.getEffet());
        }
        return tmp;
    }

    public boolean canPlayCard(Carte carte) {
        int coutPMCarte = 0;
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

}
