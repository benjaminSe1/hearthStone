package board;

import java.util.ArrayList;

import card.Card;
import card.minion.Serviteur;
import util.MyLogger;

public class Board {

    public ArrayList<Serviteur> serviteurs;
    private int nbEncouragements;

    public Board() {
        this.serviteurs = new ArrayList<>();
        this.nbEncouragements = 0;
    }

    public void ajouterCarte(Serviteur serviteur) {
        if (serviteur.charger()) {
            serviteur.changerEtatAttaquer();
        }
        this.serviteurs.add(serviteur);
    }

    public void supprimerCarte(Serviteur serviteur) {
        this.serviteurs.remove(serviteur);
    }

    public ArrayList<Serviteur> getServiteursTerrain() {
        return serviteurs;
    }


    public void afficherTerrain() {
        int i = 1;
        for (Card c : serviteurs) {
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public void reveillerTerrain() {
        for (Serviteur s : serviteurs) {
            s.changerEtatAttaquer();
        }
    }

    public void activerEncouragement() {
        int encouragementRefresh = 0;
        for (Serviteur s : serviteurs) {
            if (s.encourager()) {
                encouragementRefresh++;
            }
        }
        for (Serviteur s : serviteurs) {
            s.ajouterPD(encouragementRefresh - nbEncouragements);
        }
        nbEncouragements = encouragementRefresh;
    }

    public ArrayList<Serviteur> getServiteursReveillesTerrain() {
        ArrayList<Serviteur> lesServiteurs = new ArrayList<>();
        for (Serviteur s : serviteurs) {
            if (s.estReveille()) {
                lesServiteurs.add(s);
            }

        }
        return lesServiteurs;
    }

    public ArrayList<Serviteur> getServiteursAttaquePossible() {
        ArrayList<Serviteur> lesServiteursProvocation = new ArrayList<>();
        for (Serviteur s : serviteurs) {
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
        for (Serviteur s : serviteurs) {
            if (s.provoquer()) {
                return true;
            }
        }
        return false;
    }

    public boolean contientCarteReveille() {
        for (Serviteur s : serviteurs) {
            if (s.estReveille()) {
                return true;
            }
        }
        return false;
    }

    public void setServiteurs(ArrayList<Serviteur> serviteurs) {
        this.serviteurs = serviteurs;
    }
}