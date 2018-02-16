package board;

import card.Card;
import card.minion.Minion;
import util.MyLogger;

import java.util.ArrayList;

public class Board {

    public ArrayList<Minion> minions;
    private int nbEnhancements;

    /**
     * Contructeur de la classe Board
     */
    public Board() {
        this.minions = new ArrayList<>();
        this.nbEnhancements = 0;
    }

    /**
     *  Méthode qui permet d'ajouter un serviteur au board
     * @param minion
     */
    public void addMinion(Minion minion) {
        if (minion.charge()) {
            minion.toStateReady();
        }
        this.minions.add(minion);
    }

    /**
     * Enlève un serviteur du board
     * @param minion Le serviteur qui est enlevé du board
     */
    public void removeMinion(Minion minion) {
        this.minions.remove(minion);
    }

    /**
     * Méthode qui permet de retourner les serviteurs présents sur le board
     * @return les serviteurs présents sur le board
     */
    public ArrayList<Minion> getBoardMinions() {
        return minions;
    }

    /**
     * Méthode qui permet d'afficher les serviteurs présents sur le board
     */
    public void displayBoard() {
        int i = 1;
        for (Card c : minions) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    /**
     * Méthode qui permet de "reveiller" les serviteurs du board, c'est a dire d eleur permettre d'attaquer
     */
    public void wakeBoard() {
        for (Minion s : minions) {
            s.toStateReady();
        }
    }

    /**
     * Méthode qui permet de rajouter un point de dégat à tous les serviteurs du board
     */
    public void enhance() {
        int enhanceRefresh = 0;
        for (Minion s : minions) {
            if (s.enhance()) {
                enhanceRefresh++;
            }
        }
        for (Minion s : minions) {
            s.addDP(enhanceRefresh - nbEnhancements);
        }
        nbEnhancements = enhanceRefresh;
    }

    /**
     * Méthode qui permet de retourner une liste des minions prêts à attaquer
     * @return liste des minions prêts à attaquer
     */
    public ArrayList<Minion> getReadyMinions() {
        ArrayList<Minion> minions = new ArrayList<>();
        for (Minion s : this.minions) {
            if (s.isAwaken()) {
                minions.add(s);
            }

        }
        return minions;
    }

    /**
     * Méthode qui permet d'afficher une liste des minions pouvant attaquer
     */
    public void displayReadyMinions() {
        int i = 1;
        for (Card c : getReadyMinions()) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    /**
     * Méthode qui permet de retourner une liste des minions pouvant être attaquer
     * @return liste des minions pouvant être attaquer
     */
    public ArrayList<Minion> getAttackableMinions() {
        ArrayList<Minion> tauntMinions = new ArrayList<>();
        for (Minion s : minions) {
            if (s.taunt()) {
                tauntMinions.add(s);
            }
        }
        if (tauntMinions.size() > 0) {
            return tauntMinions;
        }
        return getBoardMinions();
    }
    /**
     * Méthode qui permet d'afficher une liste des minions pouvant être attaquer
     */
    public void displayAttackableMinions() {
        int i = 1;
        for (Card c : getAttackableMinions()) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    /**
     * Méthode qui permet de savoir si le board contient un serviteur avec provocation
     * @return True si minion avec provocation présent, false sinon
     */
    public boolean containsTauntMinion() {
        for (Minion s : minions) {
            if (s.taunt()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode qui permet de savoir si le board contient au moins un serviteur prêt a attaquer
     * @return True si au moins un serviteur prêt a attaquer, false sinon
     */
    public boolean containsAwakenMinion() {
        for (Minion s : minions) {
            if (s.isAwaken()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode qui permet de modifier la liste contenant les serviteurs du board
     * @param minions la nouvelle liste
     */
    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }
}
