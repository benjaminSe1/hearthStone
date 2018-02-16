package application;

import java.util.Random;
import java.util.Scanner;
import board.Player;
import card.Card;
import card.minion.Minion;
import card.spell.Spell;
import hero.factory.GuerrierFactory;
import hero.factory.HeroFactory;
import hero.factory.MageFactory;
import hero.factory.PaladinFactory;
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

        int tour = 1;
        while (true) {
            MyLogger.game("Tour " + tour);
            //tant que tour < 10, on incrémente la mana
            if (tour < 10) {
                application.player1.getHero().incrementerMana();
                application.player2.getHero().incrementerMana();
            }
            //on vérifie que les deux héros on toujours au moins 1 pv
            application.joueurTour(application, tour);
            MyLogger.game("Tour " + tour + " terminé");
            tour++;
            application.player1.getHero().majTourPM((tour > 10 ? 10 : tour));
            application.player2.getHero().majTourPM((tour > 10 ? 10 : tour));
        }
    }

    public void joueurTour(Application application, int tour) {
        int tourJoueur1 = application.player1.getOrdreJoueur();
        int tourJoueur2 = application.player2.getOrdreJoueur();

        if (tourJoueur2 > tourJoueur1) {
            action(application.player1, application.player2, tour);
            action(application.player2, application.player1, tour);
        } else {
            action(application.player2, application.player1, tour);
            action(application.player1, application.player2, tour);
        }
    }

    public void action(Player j, Player adversaire, int tour) {
        MyLogger.game("C'est à " + j.getPseudo() + " de jouer");
        int idAction = 0;
        this.piocherCarte(j);

        MyLogger.game("Mana : " + j.getHero().getPM());
        while (true) {

            j.getBoard().activerEncouragement();
            adversaire.getBoard().activerEncouragement();

            MyLogger.line();
            MyLogger.game("Votre terrain    : " + j.getHero().toString());
            j.getBoard().afficherTerrain();
            MyLogger.line();
            MyLogger.game("Votre adversaire : " + adversaire.getHero().toString());
            adversaire.getBoard().afficherTerrain();
            MyLogger.line();
            MyLogger.game("Quelle action souhaitez-vous effectuer ?");
            MyLogger.game("1 - Jouer une card");
            MyLogger.game("2 - Attaquer");
            MyLogger.game("3 - Utiliser l'effet du héros (" + j.getHero().getEffet().toString() + ")");
            MyLogger.game("4 - Afficher info game");
            MyLogger.game("5 - Terminer votre tour");
            idAction = MyScanner.getInt(sc, 5);

            switch (idAction) {
                case 1:
                    // Jouer une card
                    poserCarte(j, adversaire, tour);
                    break;
                case 2:
                    // Attaquer
                    prepaAttaque(j, adversaire);
                    break;
                case 3:
                    // Utiliser l'effet du héros
                    if (j.canCastHeroicPower()) {
                        j.getHero().activerEffet(j, adversaire);
                    }
                    break;
                case 4:
                    MyLogger.game("Mana : " + j.getHero().getPM());
                    break;
                case 5:
                    j.getBoard().reveillerTerrain();
                    MyLogger.playerChangement();
                    return;
                default:
                    MyLogger.error("Le joueur a rentré une action impossible à effectuer");
                    break;
            }
            j.getBoard().activerEncouragement();
            adversaire.getBoard().activerEncouragement();
        }
    }

    public void piocherCarte(Player j) {
        // On distribue les cartes au debut de chaque tour du joueur
        Card c = j.getCartePioche();
        j.ajouterCarteMain(c);
        MyLogger.game("Vous avez pioché la card : " + c.toString());
    }

    public void poserCarte(Player j, Player adversaire, int tour) {
        MyLogger.game("Veuillez jouer une card : ");

        //affichage des cartes pouvant etre jouées
        j.afficherCartesMain();

        int nbCartes = j.getCartesMain().size();
        MyLogger.game("(tapez " + Integer.toString(nbCartes + 1) + " pour retour)");

        //récupération du choix joueur
        int intScanne = MyScanner.getInt(sc, nbCartes + 1);

        //si retour choisi, retourner a la page "action"
        if (intScanne == nbCartes + 1) {
            return;
        } else {
            int idCarte = intScanne;
            Card card = j.getCartesMain().get(idCarte - 1);
            //Si la card est un minion
            if (card.isServiteur()) {
                Minion minion = (Minion) card;
                //Si le héro a suffisemment de mana
                if (j.canPlayCard(minion)) {
                    //On peut poser la card et l'ajouter au terrain
                    j.poserCarteMain(card);
                }
                //Si la card est un spell
            } else if (card.isSort()) {
                Spell spell = (Spell) card;
                //Si le héro a suffisemment de mana
                if (j.canPlayCard(spell)) {
                    //on peut poser la card et activer l'effet
                    j.poserCarteMain(card);
                    spell.getEffect().activerEffet(j, adversaire);
                }
            }
        }
    }


    public void prepaAttaque(Player j, Player adversaire) {
        //Si le héro à des minions pouvant attaquer
        if (j.getBoard().contientCarteReveille()) {
            //Si le héro adverse n'a pas de card possedant l'effet provocation
            if (!adversaire.getBoard().contientCarteProvocation()) {
                //affichage des possibilités d'attaque
                MyLogger.game("Qui voulez-vous attaquer ? 1 - Le héro , 2 - Un minion");
                int typeAttaque = MyScanner.getInt(sc, 2);
                //redirection vers la bonne méthode
                switch (typeAttaque) {
                    case 1:
                        attaquerHero(j, adversaire);
                        break;
                    case 2:
                        attaquer(j, adversaire);
                        break;
                    default:
                        MyLogger.error("Action joueur impossible à effectuer");
                        break;
                }
            } else {
                attaquer(j, adversaire);
            }
        } else {
            MyLogger.game("Attaque impossible pour le moment");
        }
    }

    private void attaquerHero(Player jAttaquant, Player adversaire) {
        //Affichage des choix possibles de minion pour attaquer le hero averse
        MyLogger.game("Veuillez choisir la card pour attaquer : ");
        jAttaquant.getBoard().afficherServiteurReveille();

        //récupération du servietur sélectionné
        int idCarteAttaquante = MyScanner.getInt(sc, jAttaquant.getBoard().getServiteursReveillesTerrain().size());
        Minion attackingMinion = jAttaquant.getBoard().getServiteursReveillesTerrain().get(idCarteAttaquante - 1);

        //Supression des points de vie du héro attaqué
        adversaire.getHero().supprimerPV(attackingMinion.getPD());
        MyLogger.game("Le héro adverse a perdu " + attackingMinion.getPD() + " PV !");

        //Si minion attaquant possède effet vol de vie, on lui redonne les PV correspondant à son attaque
        if (attackingMinion.volerVie()) {
            attackingMinion.ajouterPV(attackingMinion.getPD());
            MyLogger.game("Le minion gagne " + attackingMinion.getPD() + " PV en volant la vie !");
        }

        //Changement etat minion
        attackingMinion.changerEtatDormir();
    }

    /**
     * Méthode pour attaquer une card adversaire
     *
     * @param j          Player attaquant
     * @param adversaire Player attaqué
     */
    public void attaquer(Player j, Player adversaire) {

        // On commence par afficher les cartes pouvant être attaquées
        MyLogger.game("Veuillez attaquer une card : ");
        adversaire.getBoard().afficherTerrainAttaquePossible();

        //Et a récupérer la card que le joueur souhaite attaquer
        int idCarteAttaquee = MyScanner.getInt(sc, adversaire.getBoard().getServiteursAttaquePossible().size());
        Minion attackedMinion = adversaire.getBoard().getServiteursTerrain().get(idCarteAttaquee - 1);

        // On afficher ensuite les minions pouvant être utiliser pour attaquer
        MyLogger.game("Veuillez choisir la card pour attaquer : ");
        int i = 1;
        for (Minion s : j.getBoard().getServiteursReveillesTerrain()) {
            MyLogger.game(i + " - " + s.toString());
            i++;
        }

        //Et on récupère le minion choisit par le joueur pour attaquer
        int idCarteAttaquante = MyScanner.getInt(sc, j.getBoard().getServiteursReveillesTerrain().size());
        Minion attackingMinion = j.getBoard().getServiteursReveillesTerrain().get(idCarteAttaquante - 1);

        attackingMinion.setPV(attackingMinion.getPV() - attackedMinion.getPD());
        //si minion attaquant n'a plus de pv, il meurt
        if (attackingMinion.getPV() <= 0) {
            j.getBoard().supprimerCarte(attackingMinion);
            MyLogger.game("Le minion " + attackingMinion.getNom() + " a été tué");
        }

        attackedMinion.setPV(attackedMinion.getPV() - attackingMinion.getPD());
        //si minion attaquant n'a plus de pv, il meurt
        if (attackedMinion.getPV() <= 0) {
            adversaire.getBoard().supprimerCarte(attackedMinion);
            MyLogger.game("Le minion " + attackedMinion.getNom() + " a été tué");
        }


        //Si le minion attaquant a l'effet vol de vie, il récupère les PV correspondant à son attaque
        if (attackingMinion.volerVie()) {
            attackingMinion.ajouterPV(attackingMinion.getPD());
            MyLogger.game("Le minion gagne " + attackingMinion.getPD() + " PV en volant la vie !");
        }
        //Le minion attaquant est remis en mode sommeil
        attackingMinion.changerEtatDormir();

    }

    private void instancierJoueurs(Application application) {
        application.player1 = application.creerJoueur(1);
        MyLogger.playerChangement();
        application.player2 = application.creerJoueur(2);

        int ordreJoueur = new Random().nextInt(2);

        if (ordreJoueur == 1) {
            application.player1.initMain(1);
            application.player1.setOrdreJoueur(1);
            application.player2.initMain(0);
            application.player2.setOrdreJoueur(0);
        } else {
            application.player1.initMain(0);
            application.player1.setOrdreJoueur(0);
            application.player2.initMain(1);
            application.player2.setOrdreJoueur(1);
        }
    }

    private Player creerJoueur(int id) {
        MyLogger.game("Player " + id + ", Veuillez choisir un nom : ");
        String nomJoueur = MyScanner.getString(sc);
        Player player = new Player(id, nomJoueur);

        MyLogger.game("Veuillez sélectionner la classe de votre héro : 1-Paladin 2-Guerrier 3-Mage");

        HeroFactory f = null;
        int herosInt = MyScanner.getInt(sc, 3);
        switch (herosInt) {
            case 1:
                f = new PaladinFactory();
                MyLogger.game("Vous avez sélectionné le paladin");
                break;
            case 2:
                f = new GuerrierFactory();
                MyLogger.game("Vous avez sélectionné le guerrier");
                break;
            case 3:
                f = new MageFactory();
                MyLogger.game("Vous avez sélectionné le mage");
                break;
            default:
                MyLogger.game("Choix impossible, veuillez recommencer");
                this.creerJoueur(id);
        }
        player.setHero(f.creerHeros());

        return player;
    }
}
