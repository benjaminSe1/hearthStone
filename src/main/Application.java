package main;

import java.util.Random;
import java.util.Scanner;

import board.Player;
import card.Card;
import card.minion.Serviteur;
import card.spell.Sort;
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

        MyLogger.jeu("Projet Mini HearthStone");

        application.instancierJoueurs(application);

        int tour = 1;
        while (true) {
            MyLogger.jeu("Tour " + tour);
            //tant que tour < 10, on incrémente la mana
            if (tour < 10) {
                application.player1.getHero().incrementerMana();
                application.player2.getHero().incrementerMana();
            }
            //on vérifie que les deux héros on toujours au moins 1 pv
            application.joueurTour(application, tour);
            MyLogger.jeu("Tour " + tour + " terminé");
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
        MyLogger.jeu("C'est à " + j.getPseudo() + " de jouer");
        int idAction = 0;
        this.piocherCarte(j);

        MyLogger.jeu("Mana : " + j.getHero().getPM());
        while (true) {

            j.getBoard().activerEncouragement();
            adversaire.getBoard().activerEncouragement();

            MyLogger.line();
            MyLogger.jeu("Votre terrain    : " + j.getHero().toString());
            j.getBoard().afficherTerrain();
            MyLogger.line();
            MyLogger.jeu("Votre adversaire : " + adversaire.getHero().toString());
            adversaire.getBoard().afficherTerrain();
            MyLogger.line();
            MyLogger.jeu("Quelle action souhaitez-vous effectuer ?");
            MyLogger.jeu("1 - Jouer une card");
            MyLogger.jeu("2 - Attaquer");
            MyLogger.jeu("3 - Utiliser l'effet du héros (" + j.getHero().getEffet().toString() + ")");
            MyLogger.jeu("4 - Afficher info jeu");
            MyLogger.jeu("5 - Terminer votre tour");
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
                    MyLogger.jeu("Mana : " + j.getHero().getPM());
                    break;
                case 5:
                    j.getBoard().reveillerTerrain();
                    MyLogger.changementJoueur();
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
        MyLogger.jeu("Vous avez pioché la card : " + c.toString());
    }

    public void poserCarte(Player j, Player adversaire, int tour) {
        MyLogger.jeu("Veuillez jouer une card : ");

        //affichage des cartes pouvant etre jouées
        j.afficherCartesMain();

        int nbCartes = j.getCartesMain().size();
        MyLogger.jeu("(tapez " + Integer.toString(nbCartes + 1) + " pour retour)");

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
                Serviteur serviteur = (Serviteur) card;
                //Si le héro a suffisemment de mana
                if (j.canPlayCard(serviteur)) {
                    //On peut poser la card et l'ajouter au terrain
                    j.poserCarteMain(card);
                }
                //Si la card est un spell
            } else if (card.isSort()) {
                Sort sort = (Sort) card;
                //Si le héro a suffisemment de mana
                if (j.canPlayCard(sort)) {
                    //on peut poser la card et activer l'effet
                    j.poserCarteMain(card);
                    sort.getEffet().activerEffet(j, adversaire);
                }
            }
        }
    }


    public void prepaAttaque(Player j, Player adversaire) {
        //Si le héro à des serviteurs pouvant attaquer
        if (j.getBoard().contientCarteReveille()) {
            //Si le héro adverse n'a pas de card possedant l'effet provocation
            if (!adversaire.getBoard().contientCarteProvocation()) {
                //affichage des possibilités d'attaque
                MyLogger.jeu("Qui voulez-vous attaquer ? 1 - Le héro , 2 - Un minion");
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
            MyLogger.jeu("Attaque impossible pour le moment");
        }
    }

    private void attaquerHero(Player jAttaquant, Player adversaire) {
        //Affichage des choix possibles de minion pour attaquer le hero averse
        MyLogger.jeu("Veuillez choisir la card pour attaquer : ");
        jAttaquant.getBoard().afficherServiteurReveille();

        //récupération du servietur sélectionné
        int idCarteAttaquante = MyScanner.getInt(sc, jAttaquant.getBoard().getServiteursReveillesTerrain().size());
        Serviteur serviteurAttaquant = jAttaquant.getBoard().getServiteursReveillesTerrain().get(idCarteAttaquante - 1);

        //Supression des points de vie du héro attaqué
        adversaire.getHero().supprimerPV(serviteurAttaquant.getPD());
        MyLogger.jeu("Le héro adverse a perdu " + serviteurAttaquant.getPD() + " PV !");

        //Si minion attaquant possède effet vol de vie, on lui redonne les PV correspondant à son attaque
        if (serviteurAttaquant.volerVie()) {
            serviteurAttaquant.ajouterPV(serviteurAttaquant.getPD());
            MyLogger.jeu("Le minion gagne " + serviteurAttaquant.getPD() + " PV en volant la vie !");
        }

        //Changement etat minion
        serviteurAttaquant.changerEtatDormir();
    }

    /**
     * Méthode pour attaquer une card adversaire
     *
     * @param j          Player attaquant
     * @param adversaire Player attaqué
     */
    public void attaquer(Player j, Player adversaire) {

        // On commence par afficher les cartes pouvant être attaquées
        MyLogger.jeu("Veuillez attaquer une card : ");
        adversaire.getBoard().afficherTerrainAttaquePossible();

        //Et a récupérer la card que le joueur souhaite attaquer
        int idCarteAttaquee = MyScanner.getInt(sc, adversaire.getBoard().getServiteursAttaquePossible().size());
        Serviteur serviteurAttaque = adversaire.getBoard().getServiteursTerrain().get(idCarteAttaquee - 1);

        // On afficher ensuite les serviteurs pouvant être utiliser pour attaquer
        MyLogger.jeu("Veuillez choisir la card pour attaquer : ");
        int i = 1;
        for (Serviteur s : j.getBoard().getServiteursReveillesTerrain()) {
            MyLogger.jeu(i + " - " + s.toString());
            i++;
        }

        //Et on récupère le minion choisit par le joueur pour attaquer
        int idCarteAttaquante = MyScanner.getInt(sc, j.getBoard().getServiteursReveillesTerrain().size());
        Serviteur serviteurAttaquant = j.getBoard().getServiteursReveillesTerrain().get(idCarteAttaquante - 1);

        serviteurAttaquant.setPV(serviteurAttaquant.getPV() - serviteurAttaque.getPD());
        //si minion attaquant n'a plus de pv, il meurt
        if (serviteurAttaquant.getPV() <= 0) {
            j.getBoard().supprimerCarte(serviteurAttaquant);
            MyLogger.jeu("Le minion " + serviteurAttaquant.getNom() + " a été tué");
        }

        serviteurAttaque.setPV(serviteurAttaque.getPV() - serviteurAttaquant.getPD());
        //si minion attaquant n'a plus de pv, il meurt
        if (serviteurAttaque.getPV() <= 0) {
            adversaire.getBoard().supprimerCarte(serviteurAttaque);
            MyLogger.jeu("Le minion " + serviteurAttaque.getNom() + " a été tué");
        }


        //Si le minion attaquant a l'effet vol de vie, il récupère les PV correspondant à son attaque
        if (serviteurAttaquant.volerVie()) {
            serviteurAttaquant.ajouterPV(serviteurAttaquant.getPD());
            MyLogger.jeu("Le minion gagne " + serviteurAttaquant.getPD() + " PV en volant la vie !");
        }
        //Le minion attaquant est remis en mode sommeil
        serviteurAttaquant.changerEtatDormir();

    }

    private void instancierJoueurs(Application application) {
        application.player1 = application.creerJoueur(1);
        MyLogger.changementJoueur();
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
        MyLogger.jeu("Player " + id + ", Veuillez choisir un nom : ");
        String nomJoueur = MyScanner.getString(sc);
        Player player = new Player(id, nomJoueur);

        MyLogger.jeu("Veuillez sélectionner la classe de votre héro : 1-Paladin 2-Guerrier 3-Mage");

        HeroFactory f = null;
        int herosInt = MyScanner.getInt(sc, 3);
        switch (herosInt) {
            case 1:
                f = new PaladinFactory();
                MyLogger.jeu("Vous avez sélectionné le paladin");
                break;
            case 2:
                f = new GuerrierFactory();
                MyLogger.jeu("Vous avez sélectionné le guerrier");
                break;
            case 3:
                f = new MageFactory();
                MyLogger.jeu("Vous avez sélectionné le mage");
                break;
            default:
                MyLogger.jeu("Choix impossible, veuillez recommencer");
                this.creerJoueur(id);
        }
        player.setHero(f.creerHeros());

        return player;
    }
}
