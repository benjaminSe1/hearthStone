package board;

import java.util.ArrayList;

import card.Card;
import card.minion.Minion;
import util.MyLogger;

public class Board {

    public ArrayList<Minion> minions;
    private int nbEncouragements;

    public Board() {
        this.minions = new ArrayList<>();
        this.nbEncouragements = 0;
    }

    public void ajouterCarte(Minion minion) {
        if (minion.charger()) {
            minion.changerEtatAttaquer();
        }
        this.minions.add(minion);
    }

    public void supprimerCarte(Minion minion) {
        this.minions.remove(minion);
    }

    public ArrayList<Minion> getServiteursTerrain() {
        return minions;
    }


    public void afficherTerrain() {
        int i = 1;
        for (Card c : minions) {
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public void reveillerTerrain() {
        for (Minion s : minions) {
            s.changerEtatAttaquer();
        }
    }

    public void activerEncouragement() {
        int encouragementRefresh = 0;
        for (Minion s : minions) {
            if (s.encourager()) {
                encouragementRefresh++;
            }
        }
        for (Minion s : minions) {
            s.ajouterPD(encouragementRefresh - nbEncouragements);
        }
        nbEncouragements = encouragementRefresh;
    }

    public ArrayList<Minion> getServiteursReveillesTerrain() {
        ArrayList<Minion> minions = new ArrayList<>();
        for (Minion s : this.minions) {
            if (s.estReveille()) {
                minions.add(s);
            }

        }
        return minions;
    }

    public ArrayList<Minion> getServiteursAttaquePossible() {
        ArrayList<Minion> lesServiteursProvocation = new ArrayList<>();
        for (Minion s : minions) {
            if (s.provoquer()) {
                lesServiteursProvocation.add(s);
            }
        }
        if (lesServiteursProvocation.size() > 0) {
            return lesServiteursProvocation;
        }
        return getServiteursTerrain();
    }

    public void afficherTerrainAttaquePossible() {
        int i = 1;
        for (Card c : getServiteursAttaquePossible()) {
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public void afficherServiteurReveille() {
        int i = 1;
        for (Card c : getServiteursReveillesTerrain()) {
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public boolean contientCarteProvocation() {
        for (Minion s : minions) {
            if (s.provoquer()) {
                return true;
            }
        }
        return false;
    }

    public boolean contientCarteReveille() {
        for (Minion s : minions) {
            if (s.estReveille()) {
                return true;
            }
        }
        return false;
    }

    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }
}
