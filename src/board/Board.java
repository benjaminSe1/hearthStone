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
            minion.toSleepReady();
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
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public void wakeBoard() {
        for (Minion s : minions) {
            s.toSleepReady();
        }
    }

    public void enhance() {
        int encouragementRefresh = 0;
        for (Minion s : minions) {
            if (s.enhance()) {
                encouragementRefresh++;
            }
        }
        for (Minion s : minions) {
            s.addDP(encouragementRefresh - nbEnhancements);
        }
        nbEnhancements = encouragementRefresh;
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
        ArrayList<Minion> lesServiteursProvocation = new ArrayList<>();
        for (Minion s : minions) {
            if (s.taunt()) {
                lesServiteursProvocation.add(s);
            }
        }
        if (lesServiteursProvocation.size() > 0) {
            return lesServiteursProvocation;
        }
        return getBoardMinions();
    }

    public void displayAttackableMinions() {
        int i = 1;
        for (Card c : getAttackableMinions()) {
            MyLogger.jeu(i + " - " + c.toString());
            i++;
        }
    }

    public void displayAwakenMinions() {
        int i = 1;
        for (Card c : getReadyMinions()) {
            MyLogger.jeu(i + " - " + c.toString());
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
