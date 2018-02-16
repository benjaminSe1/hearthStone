package board;

import card.Card;
import card.minion.Minion;
import card.minion.MinionSimple;
import card.spell.Spell;
import hero.Hero;
import util.MyLogger;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String pseudo;

    private int playerOrder;

    private ArrayList<Card> playerHand;
    private Hero hero;
    private Board board;

    public Player(String pseudo) {
        super();
        this.pseudo = pseudo;
        this.playerHand = new ArrayList<>();
        this.board = new Board();
    }


    public String getPseudo() {
        return pseudo;
    }

    public int getPlayerOrder() {
        return playerOrder;
    }

    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    public void initHand(int playerOrder) {
        int i = 0;
        if (playerOrder == 0) {
            while (i < 3) {
                this.addCardHand(this.getDraw());
                i++;
            }
        } else {
            while (i < 4) {
                this.addCardHand(this.getDraw());
                i++;
            }
        }
    }

    public void addCardHand(Card card) {
        this.playerHand.add(card);
    }

    public void playCardHand(Card card) {
        this.playerHand.remove(card);
        this.getHero().removeMP(card.getMP());
        if (card.isMinion()) {
            this.getBoard().addMinion((Minion) card);
        }
    }

    public ArrayList<Card> getHand() {
        return playerHand;
    }

    public void displayHand() {
        int i = 1;
        for (Card c : playerHand) {
            MyLogger.game(i + " - " + c.toString());
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

    public Card getDraw() {
        ArrayList<Card> cards = this.hero.getHeroCards();
        Card tmp = cards.get((new Random()).nextInt(cards.size()));
        if (tmp.isMinion()) {
            Minion tmpMinion = (Minion) tmp;
            tmp = new MinionSimple(tmpMinion.getName(), tmpMinion.getMP(), tmpMinion.getDP(), tmpMinion.getHP());
        } else {
            Spell tmpSpell = (Spell) tmp;
            tmp = new Spell(tmpSpell.getName(), tmpSpell.getMP(), tmpSpell.getEffect());
        }
        return tmp;
    }

    public boolean canPlayCard(Card card) {
        int cardManaCost = 0;
        cardManaCost = card.getMP();
        if (cardManaCost > hero.getMP()) {
            MyLogger.game("Vous n'avez pas assez de Point de Mana pour jouer cette carte");
            return false;
        }
        return true;
    }

    public boolean canCastHeroicPower() {
        if (hero.getMP() < 2) {
            MyLogger.game("Vous n'avez pas assez de Point de Mana pour lancer votre sort");
            return false;
        }
        return true;
    }

}
