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

    /**
     * Constructeur de la classe Player
     * @param pseudo pseudo du joueur
     */
    public Player(String pseudo) {
        super();
        this.pseudo = pseudo;
        this.playerHand = new ArrayList<>();
        this.board = new Board();
    }

    /**
     * Méthode qui retourne le pseudo du joueur
     * @return le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Méthode qui retourne l'ordre du joueur
     * @return l'ordre du joueur
     */
    public int getPlayerOrder() {
        return playerOrder;
    }

    /**
     * Méthode qui permet de modifier l'ordre du joueur
     * @param playerOrder le nouvel ordre du joueur
     */
    public void setPlayerOrder(int playerOrder) {
        this.playerOrder = playerOrder;
    }

    /**
     * Méthode qui permet d'initialiser la main du joueur en debut de partie avec les cartes du deck
     */
    public void initHand() {
        int i = 0;
        if (this.playerOrder == 0) {
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

    /**
     * Méthode qui permet d'ajouter une carte à la main du héro
     * @param card la carte a ajouter
     */
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

    /**
     * Méthode qui permet de récupérer la main du joueur
     * @return liste de carte représentant la main du joueur
     */
    public ArrayList<Card> getHand() {
        return playerHand;
    }

    /**
     *  Méthode qui permet d'afficher la main du joueur
     */
    public void displayHand() {
        int i = 1;
        for (Card c : playerHand) {
            MyLogger.game(i + " - " + c.toString());
            i++;
        }
    }

    /**
     * Méthode qui permet de récupérer le board du joueur (serviteur posé)
     * @return liste des serviteurs posés
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Méthode qui permet de récupérer le héro du joueur
     * @return le héro du joueur
     */
    public Hero getHero() {
        return hero;
    }

    /**
     * Méthode qui permet de modifier le héro du joueur
     * @param hero le nouvel hero du joueur
     */
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    /**
     * Méthode qui permet au joueur de piocher une carte du deck
     * @return La carte piochée
     */
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

    /**
     * Méthode qui permet de savoir si la carte passé en paramêtre peut être joué par le joueur
     * @param card la carte à tester
     * @return True si la carte peut être jouée, False sinon
     */
    public boolean canPlayCard(Card card) {
        int cardManaCost = 0;
        cardManaCost = card.getMP();
        if (cardManaCost > hero.getMP()) {
            MyLogger.game("Vous n'avez pas assez de Point de Mana pour jouer cette carte");
            return false;
        }
        return true;
    }

    /**
     * Méthode qui permet de savoir si le heri du joueur peut lancer son pouvoir héroique
     * @return True si il peut lancer son sort, False sinon
     */
    public boolean canCastHeroicPower() {
        if (hero.getMP() < 2) {
            MyLogger.game("Vous n'avez pas assez de Point de Mana pour lancer votre sort");
            return false;
        }
        return true;
    }

}
