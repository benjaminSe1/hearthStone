package application;

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

    private Player player1;

    private Player player2;


    public static void main(String[] args) {
        Application application = new Application();
        MyLogger.game("Projet Mini HearthStone");

        application.instancierJoueurs();
        int turn = 1;
        while (true) {
            MyLogger.game("Tour " + turn);
            //tant que tour < 10, on incrémente la mana
            if (turn < 10) {
                application.player1.getHero().incrementMP();
                application.player2.getHero().incrementMP();
            }
            //on vérifie que les deux héros on toujours au moins 1 pv
            application.joueurTour();
            MyLogger.game("Tour " + turn + " terminé");
            turn++;
            application.player1.getHero().updateTurnMP((turn > 10 ? 10 : turn));
            application.player2.getHero().updateTurnMP((turn > 10 ? 10 : turn));
        }
    }

    /**
     * Méthode qui permet de gérer l'ordre joueurs dans le tour
     */
    private void joueurTour() {
        int turnPlayer1 = this.player1.getPlayerOrder();
        int turnPlayer2 = this.player2.getPlayerOrder();
        if (turnPlayer2 > turnPlayer1) {
            action(this.player1, this.player2);
            action(this.player2, this.player1);
        } else {
            action(this.player2, this.player1);
            action(this.player1, this.player2);
        }
    }

    private void action(Player p, Player opponent) {
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
                    // Jouer une carte
                    playCard(p, opponent);
                    break;
                case 2:
                    // Attaquer
                    prepareAttack(p, opponent);
                    break;
                case 3:
                    // Utiliser l'effet du héros
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

    /**
     * Méthode qui permet au joueur passé en parametre de piocher une carte (de son deck à sa main)
     * @param p - Le Joueur
     */
    private void draw(Player p) {
        // On distribue les cartes au debut de chaque tour du joueur
        Card c = p.getDraw();
        p.addCardHand(c);
        MyLogger.game("Vous avez pioché la carte: " + c.toString());
    }

    /**
     * Méthode qui permet de joueur une carte, Serviteur ou Sort (de la main au Bord)
     * @param p Player qui joue la carte
     * @param opponent Player adversaire du player p
     */
    private void playCard(Player p, Player opponent) {
        MyLogger.game("Veuillez jouer une carte : ");
        p.displayHand();
        int nbCards = p.getHand().size();
        MyLogger.game("(tapez " + Integer.toString(nbCards + 1) + " pour retour)");

        //récupération du choix joueur
        int intScanned = MyScanner.getInt(sc, nbCards + 1);

        //si retour choisi, retour a la page "action"
        if (intScanned == nbCards + 1) {
            return;
        } else {
            Card card = p.getHand().get(intScanned - 1);
            //Si la carte est un serviteur
            if (card.isMinion()) {
                Minion minion = (Minion) card;
                //Si le héro a suffisemment de mana
                if (p.canPlayCard(minion)) {
                    //On peut poser la carte et l'ajouter au terrain
                    p.playCardHand(card);
                }
                //Si la carte est un sort
            } else if (card.isSpell()) {
                Spell spell = (Spell) card;
                //Si le héro a suffisemment de mana
                if (p.canPlayCard(spell)) {
                    //on peut poser la carte et activer l'effet
                    p.playCardHand(card);
                    spell.getEffect().activateEffect(p, opponent);
                }
            }
        }
    }

    /**
     * Méthode qui permet de préparer une attaque soit envers le hero adverse soit envers un serviteur adverse
     * @param p Player qui joue la carte
     * @param opponent Player adversaire du player p
     */
    private void prepareAttack(Player p, Player opponent) {
        //Si le héro à des serviteurs pouvant attaquer
        if (p.getBoard().containsAwakenMinion()) {
            //Si le héro adverse n'a pas de carte possedant l'effet provocation
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
                        this.prepareAttack(p, opponent);
                        break;
                }
            } else {
                attack(p, opponent);
            }
        } else {
            MyLogger.game("Attaque impossible pour le moment");
        }
    }

    /**
     * Méthode qui gère l'attaque d'un héro
     * @param pAttack le joueur qui attaque
     * @param opponent le joueur attaqué
     */
    private void attackHero(Player pAttack, Player opponent) {
        //Affichage des choix possibles de serviteur pour attaquer le hero averse
        MyLogger.game("Veuillez choisir la carte pour attaquer : ");
        pAttack.getBoard().displayReadyMinions();

        //récupération du servietur sélectionné
        int idAttackingCard = MyScanner.getInt(sc, pAttack.getBoard().getReadyMinions().size());
        Minion attackingMinion = pAttack.getBoard().getReadyMinions().get(idAttackingCard - 1);

        //Supression des points de vie du héro attaqué
        opponent.getHero().removeHP(attackingMinion.getDP());
        MyLogger.game("Le héro adverse a perdu " + attackingMinion.getDP() + " HP !");
        //Si serviteur attaquant possède l'effet vol de vie, on lui redonne les HP correspondant à son attaque
        if (attackingMinion.stealLife()) {
            attackingMinion.addHP(attackingMinion.getDP());
            MyLogger.game("Le minion gagne " + attackingMinion.getDP() + " HP en volant la vie !");
        }
        //Changement etat serviteur
        attackingMinion.toStateSleep();
    }

    /**
     * Méthode pour attaquer un serviteur
     *
     * @param p        Joueur attaquant
     * @param opponent Joueur attaqué
     */
    private void attack(Player p, Player opponent) {
        // On commence par afficher les cartes pouvant être attaquées
        MyLogger.game("Veuillez attaquer une carte : ");
        opponent.getBoard().displayAttackableMinions();

        //Et a récupérer la carte que le joueur souhaite attaquer
        int idAttackedCard = MyScanner.getInt(sc, opponent.getBoard().getAttackableMinions().size());
        Minion attackedMinion = opponent.getBoard().getBoardMinions().get(idAttackedCard - 1);

        //On affiche ensuite les serviteurs pouvant être utilisés pour attaquer
        MyLogger.game("Veuillez choisir la carte pour attaquer : ");
        p.getBoard().displayReadyMinions();

        //Et on récupère le serviteur choisit par le joueur pour attaquer
        int idAttackingCard = MyScanner.getInt(sc, p.getBoard().getReadyMinions().size());
        Minion attackingMinion = p.getBoard().getReadyMinions().get(idAttackingCard - 1);
        attackingMinion.setHP(attackingMinion.getHP() - attackedMinion.getDP());

        //si serviteur attaquant n'a plus de pv, il meurt
        if (this.checkMinionDead(attackingMinion)) {
            p.getBoard().removeMinion(attackingMinion);
        }

        attackedMinion.setHP(attackedMinion.getHP() - attackingMinion.getDP());
        //si serviteur attaquant n'a plus de pv, il meurt
        if (this.checkMinionDead(attackedMinion)) {
            opponent.getBoard().removeMinion(attackedMinion);
        }
        //Si le serviteur attaquant a l'effet vol de vie, il récupère les HP correspondant à son attaque
        if (attackingMinion.stealLife()) {
            attackingMinion.addHP(attackingMinion.getDP());
            MyLogger.game("Le minion gagne " + attackingMinion.getDP() + " HP en volant la vie !");
        }
        //Le serviteur attaquant est remis en mode sommeil
        attackingMinion.toStateSleep();
    }

    /**
     * Méthode qui verifie qu'un serviteur est plus de 0 hp
     * @param m Le serviteur sur lequel on effectue la vérification
     * @return Boolean - true si le serviteur est mort, false sinon
     */
    private boolean checkMinionDead(Minion m){
        if (m.getHP() <= 0) {
            MyLogger.game("Le serviteur " + m.getName() + " a été tué");
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Méthode qui instancie les deux joueurs grâce à la méthode createPLayer
     */
    private void instancierJoueurs() {
        this.player1 = this.createPlayer();
        MyLogger.switchPlayer();
        this.player2 = this.createPlayer();

        int ordreJoueur = new Random().nextInt(2);

        if (ordreJoueur == 1) {
            this.player1.initHand();
            this.player1.setPlayerOrder(1);
            this.player2.initHand();
            this.player2.setPlayerOrder(0);
        } else {
            this.player1.initHand();
            this.player1.setPlayerOrder(0);
            this.player2.initHand();
            this.player2.setPlayerOrder(1);
        }
    }

    /**
     * Méthode qui créé un joueur
     * @return le player qui est créé
     */
    private Player createPlayer() {
        MyLogger.game("Veuillez choisir un nom : ");
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
                this.createPlayer();
        }
        player.setHero(f.createHero());
        return player;
    }
}
