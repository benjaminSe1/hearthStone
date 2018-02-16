package board;

import java.util.ArrayList;

import card.Card;
import card.minion.Minion;
import util.MyLogger;

public class Board {

    public ArrayList<Minion> minions;

    private int nbEnhancements;

    public Board() {
        this.minions = new ArrayList<>();
        this.nbEnhancements = 0;
    }

    public void addMinion(Minion minion) {
        if (minion.charge()) {
            minion.toStateReady();
        }
        this.minions.add(minion);
    }

    public void removeMinion(Minion minion) {
        this.minions.remove(minion);
    }

    public ArrayList<Minion> getBoardMinions() {
        return minions;
    }

    public void displayBoard() {
        int i = 1;
        for (Card c : minions) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    public void wakeBoard() {
        for (Minion s : minions) {
            s.toStateReady();
        }
    }

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

    public ArrayList<Minion> getReadyMinions() {
        ArrayList<Minion> minions = new ArrayList<>();
        for (Minion s : this.minions) {
            if (s.isAwaken()) {
                minions.add(s);
            }

        }
        return minions;
    }

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

    public void displayAttackableMinions() {
        int i = 1;
        for (Card c : getAttackableMinions()) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    public void displayAwakenMinions() {
        int i = 1;
        for (Card c : getReadyMinions()) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    public boolean containsTauntMinion() {
        for (Minion s : minions) {
            if (s.taunt()) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAwakenMinion() {
        for (Minion s : minions) {
            if (s.isAwaken()) {
                return true;
            }
        }
        return false;
    }

    public void setMinions(ArrayList<Minion> minions) {
        this.minions = minions;
    }
}
