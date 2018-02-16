package main;

import java.util.Random;
import java.util.Scanner;

import board.Player;
import card.Card;
import card.minion.Minion;
import card.spell.Spell;
import hero.factory.HeroFactory;
import hero.factory.MageFactory;
import hero.factory.PaladinFactory;
import hero.factory.WarriorFactory;
import util.MyLogger;
import util.MyScanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    Player player1;
    Player player2;

    public static void main(String[] args) {
        Application application = new Application();
        MyLogger.game("Projet Mini HearthStone");

        application.instancierJoueurs(application);
        int turn = 1;
        while (true) {
            MyLogger.game("Tour " + turn);
            //tant que tour < 10, on incrémente la mana
            if (turn < 10) {
                application.player1.getHero().incrementMP();
                application.player2.getHero().incrementMP();
            }
            //on vérifie que les deux héros on toujours au moins 1 pv
            application.joueurTour(application, turn);
            MyLogger.game("Tour " + turn + " terminé");
            turn++;
            application.player1.getHero().updateTurnMP((turn > 10 ? 10 : turn));
            application.player2.getHero().updateTurnMP((turn > 10 ? 10 : turn));
        }
    }

    public void joueurTour(Application application, int turn) {
        int turnPlayer1 = application.player1.getPlayerOrder();
        int turnPlayer2 = application.player2.getPlayerOrder();
        if (turnPlayer2 > turnPlayer1) {
            action(application.player1, application.player2, turn);
            action(application.player2, application.player1, turn);
        } else {
            action(application.player2, application.player1, turn);
            action(application.player1, application.player2, turn);
        }
    }

    public void action(Player p, Player opponent, int turn) {
        MyLogger.game("C'est à " + p.getPseudo() + " de jouer");
        int idAction = 0;
        this.draw(p);
        MyLogger.game("Mana : " + p.getHero().getMP());
        while (true) {
            p.getBoard().enhance();
            opponent.getBoard().enhance();

            MyLogger.line();
            MyLogger.game("Votre terrain    : " + p.getHero().toString());
            p.getBoard().displayBoard();
            MyLogger.line();
            MyLogger.game("Votre adversaire : " + opponent.getHero().toString());
            opponent.getBoard().displayBoard();
            MyLogger.line();
            MyLogger.game("Quelle action souhaitez-vous effectuer ?");
            MyLogger.game("1 - Jouer une carte");
            MyLogger.game("2 - Attaquer");
            MyLogger.game("3 - Utiliser l'effect du héros (" + p.getHero().getEffect().toString() + ")");
            MyLogger.game("4 - Afficher info jeu");
            MyLogger.game("5 - Terminer votre tour");
            idAction = MyScanner.getInt(sc, 5);

            switch (idAction) {
                case 1:
                    // Jouer une card
                    playCard(p, opponent, turn);
                    break;
                case 2:
                    // Attaquer
                    prepareAttack(p, opponent);
                    break;
                case 3:
                    // Utiliser l'effect du héros
                    if (p.canCastHeroicPower()) {
                        p.getHero().activateEffect(p, opponent);
                    }
                    break;
                case 4:
                    MyLogger.game("Mana : " + p.getHero().getMP());
                    break;
                case 5:
                    p.getBoard().wakeBoard();
                    MyLogger.switchPlayer();
                    return;
                default:
                    MyLogger.error("Le joueur a rentré une action impossible à effectuer");
                    break;
            }
            p.getBoard().enhance();
            opponent.getBoard().enhance();
        }
    }

    public void draw(Player p) {
        // On distribue les cartes au debut de chaque tour du joueur
        Card c = p.getDraw();
        p.addCardHand(c);
        MyLogger.game("Vous avez pioché la carte: " + c.toString());
    }

    public void playCard(Player p, Player opponent, int turn) {
        MyLogger.game("Veuillez jouer une carte : ");

        //affichage des cartes pouvant etre jouées
        p.displayHand();
        int nbCards = p.getHand().size();
        MyLogger.game("(tapez " + Integer.toString(nbCards + 1) + " pour retour)");

        //récupération du choix joueur
        int intScanned = MyScanner.getInt(sc, nbCards + 1);

        //si retour choisi, retourner a la page "action"
        if (intScanned == nbCards + 1) {
            return;
        } else {
            int idCard = intScanned;
            Card card = p.getHand().get(idCard - 1);
            //Si la card est un minion
            if (card.isMinion()) {
                Minion minion = (Minion) card;
                //Si le héro a suffisemment de mana
                if (p.canPlayCard(minion)) {
                    //On peut poser la card et l'ajouter au terrain
                    p.playCardHand(card);
                }
                //Si la card est un spell
            } else if (card.isSpell()) {
                Spell spell = (Spell) card;
                //Si le héro a suffisemment de mana
                if (p.canPlayCard(spell)) {
                    //on peut poser la card et activer l'effect
                    p.playCardHand(card);
                    spell.getEffect().activateEffect(p, opponent);
                }
            }
        }
    }

    public void prepareAttack(Player p, Player opponent) {
        //Si le héro à des minions pouvant attack
        if (p.getBoard().containsAwakenMinion()) {
            //Si le héro adverse n'a pas de card possedant l'effect provocation
            if (!opponent.getBoard().containsTauntMinion()) {
                //affichage des possibilités d'attaque
                MyLogger.game("Qui voulez-vous attaquer ? 1 - Le héro , 2 - Un serviteur");
                int attackType = MyScanner.getInt(sc, 2);
                //redirection vers la bonne méthode
                switch (attackType) {
                    case 1:
                        attackHero(p, opponent);
                        break;
                    case 2:
                        attack(p, opponent);
                        break;
                    default:
                        MyLogger.error("Action joueur impossible à effectuer");
                        break;
                }
            } else {
                attack(p, opponent);
            }
        } else {
            MyLogger.game("Attaque impossible pour le moment");
        }
    }

    private void attackHero(Player pAttack, Player opponent) {
        //Affichage des choix possibles de minion pour attack le hero averse
        MyLogger.game("Veuillez choisir la carte pour attaquer : ");
        pAttack.getBoard().displayAwakenMinions();

        //récupération du servietur sélectionné
        int idAttackingCard = MyScanner.getInt(sc, pAttack.getBoard().getReadyMinions().size());
        Minion attackingMinion = pAttack.getBoard().getReadyMinions().get(idAttackingCard - 1);

        //Supression des points de vie du héro attaqué
        opponent.getHero().removeHP(attackingMinion.getDP());
        MyLogger.game("Le héro adverse a perdu " + attackingMinion.getDP() + " HP !");
        //Si minion attaquant possède effect vol de vie, on lui redonne les HP correspondant à son attaque
        if (attackingMinion.stealLife()) {
            attackingMinion.addHP(attackingMinion.getDP());
            MyLogger.game("Le minion gagne " + attackingMinion.getDP() + " HP en volant la vie !");
        }
        //Changement etat minion
        attackingMinion.toSleepState();
    }

    /**
     * Méthode pour attaquer une carte de l'adversaire
     *
     * @param p          Joueur attaquant
     * @param opponent Joueur attaqué
     */
    public void attack(Player p, Player opponent) {

        // On commence par afficher les cartes pouvant être attaquées
        MyLogger.game("Veuillez attaquer une carte : ");
        opponent.getBoard().displayAttackableMinions();
        //Et a récupérer la card que le joueur souhaite attack
        int idAttackedCard = MyScanner.getInt(sc, opponent.getBoard().getAttackableMinions().size());
        Minion attackedMinion = opponent.getBoard().getBoardMinions().get(idAttackedCard - 1);
        // On afficher ensuite les minions pouvant être utiliser pour attack
        MyLogger.game("Veuillez choisir la carte pour attaquer : ");
        int i = 1;
        for (Minion s : p.getBoard().getReadyMinions()) {
            MyLogger.game(i + " - " + s.toString());
            i++;
        }
        //Et on récupère le minion choisit par le joueur pour attack
        int idAttackingCard = MyScanner.getInt(sc, p.getBoard().getReadyMinions().size());
        Minion attackingMinion = p.getBoard().getReadyMinions().get(idAttackingCard - 1);
        attackingMinion.setHP(attackingMinion.getHP() - attackedMinion.getDP());
        //si minion attaquant n'a plus de pv, il meurt
        if (attackingMinion.getHP() <= 0) {
            p.getBoard().removeMinion(attackingMinion);
            MyLogger.game("Le serviteur " + attackingMinion.getName() + " a été tué");
        }
        attackedMinion.setHP(attackedMinion.getHP() - attackingMinion.getDP());
        //si minion attaquant n'a plus de pv, il meurt
        if (attackedMinion.getHP() <= 0) {
            opponent.getBoard().removeMinion(attackedMinion);
            MyLogger.game("Le serviteur " + attackedMinion.getName() + " a été tué");
        }
        //Si le minion attaquant a l'effect vol de vie, il récupère les HP correspondant à son attaque
        if (attackingMinion.stealLife()) {
            attackingMinion.addHP(attackingMinion.getDP());
            MyLogger.game("Le minion gagne " + attackingMinion.getDP() + " HP en volant la vie !");
        }
        //Le minion attaquant est remis en mode sommeil
        attackingMinion.toSleepState();

    }

    private void instancierJoueurs(Application application) {
        application.player1 = application.createPlayer(1);
        MyLogger.switchPlayer();
        application.player2 = application.createPlayer(2);

        int ordreJoueur = new Random().nextInt(2);

        if (ordreJoueur == 1) {
            application.player1.initHand(1);
            application.player1.setPlayerOrder(1);
            application.player2.initHand(0);
            application.player2.setPlayerOrder(0);
        } else {
            application.player1.initHand(0);
            application.player1.setPlayerOrder(0);
            application.player2.initHand(1);
            application.player2.setPlayerOrder(1);
        }
    }

    private Player createPlayer(int id) {
        MyLogger.game("Joueur " + id + ", Veuillez choisir un nom : ");
        String playerName = MyScanner.getString(sc);
        Player player = new Player(playerName);
        MyLogger.game("Veuillez sélectionner la classe de votre héro : 1-Paladin 2-Guerrier 3-Mage");

        HeroFactory f = null;
        int herosInt = MyScanner.getInt(sc, 3);
        switch (herosInt) {
            case 1:
                f = new PaladinFactory();
                MyLogger.game("Vous avez sélectionné le paladin");
                break;
            case 2:
                f = new WarriorFactory();
                MyLogger.game("Vous avez sélectionné le guerrier");
                break;
            case 3:
                f = new MageFactory();
                MyLogger.game("Vous avez sélectionné le mage");
                break;
            default:
                MyLogger.game("Choix impossible, veuillez recommencer");
                this.createPlayer(id);
        }
        player.setHero(f.createHero());

        return player;
    }
}
