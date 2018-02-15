package main;

import board.Joueur;
import carte.Carte;
import carte.serviteur.Serviteur;
import carte.sort.Sort;
import hero.factory.GuerrierFactory;
import hero.factory.HeroFactory;
import hero.factory.MageFactory;
import hero.factory.PaladinFactory;
import service.ServiceGestion;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    Joueur joueur1;
    Joueur joueur2;

    public static void main(String[] args) {
        App app = new App();

        Log.jeu("Projet Mini HearthStone");

        app.instancierJoueurs(app);

        int tour = 1;
        while (true) {
            Log.jeu("Tour " + tour);
            //tant que tour < 10, on incrémente la mana
            if (tour < 10) {
                app.joueur1.getHero().incrementerMana();
                app.joueur2.getHero().incrementerMana();
            }
            //on vérifie que les deux héros on toujours au moins 1 pv
            if (app.joueur1.getHero().getPV() <= 0 || app.joueur2.getHero().getPV() <= 0) {
                break;
            }
            app.joueurTour(app, tour);
            Log.jeu("Tour " + tour + " terminé");
            tour++;
            app.joueur1.getHero().majTourPM((tour > 10 ? 10 : tour));
            app.joueur2.getHero().majTourPM((tour > 10 ? 10 : tour));
        }
        Log.jeu("Partie terminée");
    }

    public void joueurTour(App app, int tour) {
        int tourJoueur1 = app.joueur1.getOrdreJoueur();
        int tourJoueur2 = app.joueur2.getOrdreJoueur();

        if (tourJoueur2 > tourJoueur1) {
            action(app.joueur1, app.joueur2, tour);
            action(app.joueur2, app.joueur1, tour);
        } else {
            action(app.joueur2, app.joueur1, tour);
            action(app.joueur1, app.joueur2, tour);
        }
    }

    public void action(Joueur j, Joueur adversaire, int tour) {
        Log.jeu("C'est à " + j.getPseudo() + " de jouer");
        int idAction = 0;
        this.piocherCarte(j);

        Log.jeu("Mana : " + j.getHero().getPM());
        while (true) {

            j.getTerrain().activerEncouragement();
            adversaire.getTerrain().activerEncouragement();

            Log.line();
            Log.jeu("Votre terrain    : " + j.getHero().toString());
            j.getTerrain().afficherTerrain();
            Log.line();
            Log.jeu("Votre adversaire : " + adversaire.getHero().toString());
            adversaire.getTerrain().afficherTerrain();
            Log.line();
            Log.jeu("Quelle action souhaitez-vous effectuer ?");
            Log.jeu("1 - Jouer une carte");
            Log.jeu("2 - Attaquer");
            Log.jeu("3 - Utiliser l'effet du héros (" + j.getHero().getEffet().toString() + ")");
            Log.jeu("4 - Afficher info jeu");
            Log.jeu("5 - Terminer votre tour");
            idAction = ServiceGestion.getInputInt(sc, 5);

            switch (idAction) {
                case 1:
                    // Jouer une carte
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
                    Log.jeu("Mana : " + j.getHero().getPM());
                    break;
                case 5:
                    j.getTerrain().reveillerTerrain();
                    Log.changementJoueur();
                    return;
                default:
                    Log.error("Le joueur a rentré une action impossible à effectuer");
                    break;
            }

            j.getTerrain().activerEncouragement();
            adversaire.getTerrain().activerEncouragement();
        }
    }

    public void piocherCarte(Joueur j) {
        // On distribue les cartes au debut de chaque tour du joueur
        Carte c = j.getCartePioche();
        j.ajouterCarteMain(c);
        Log.jeu("Vous avez pioché la carte : " + c.toString());
    }

    public void poserCarte(Joueur j, Joueur adversaire, int tour) {
        Log.jeu("Veuillez jouer une carte : ");

        //affichage des cartes pouvant etre jouées
        j.afficherCartesMain();

        int nbCartes = j.getCartesMain().size();
        Log.jeu("(tapez " + Integer.toString(nbCartes + 1) + " pour retour)");

        //récupération du choix joueur
        int intScanne = ServiceGestion.getInputInt(sc, nbCartes + 1);

        //si retour choisi, retourner a la page "action"
        if (intScanne == nbCartes + 1) {
            return;
        } else {
            int idCarte = intScanne;
            Carte carte = j.getCartesMain().get(idCarte - 1);
            //Si la carte est un serviteur
            if (carte.isServiteur()) {
                Serviteur serviteur = (Serviteur) carte;
                //Si le héro a suffisemment de mana
                if (j.canPlayCard(serviteur)) {
                    //On peut poser la carte et l'ajouter au terrain
                    j.poserCarteMain(carte);
                }
                //Si la carte est un sort
            } else if (carte.isSort()) {
                Sort sort = (Sort) carte;
                //Si le héro a suffisemment de mana
                if (j.canPlayCard(sort)) {
                    //on peut poser la carte et activer l'effet
                    j.poserCarteMain(carte);
                    sort.getEffet().activerEffet(j, adversaire);
                }
            }
        }
    }


    public void prepaAttaque(Joueur j, Joueur adversaire) {
        //Si le héro à des serviteurs pouvant attaquer
        if (j.getTerrain().contientCarteReveille()) {
            //Si le héro adverse n'a pas de carte possedant l'effet provocation
            if (!adversaire.getTerrain().contientCarteProvocation()) {
                //affichage des possibilités d'attaque
                Log.jeu("Qui voulez-vous attaquer ? 1 - Le héro , 2 - Un serviteur");
                int typeAttaque = ServiceGestion.getInputInt(sc, 2);
                //redirection vers la bonne méthode
                switch (typeAttaque) {
                    case 1:
                        attaquerHeros(j, adversaire);
                        break;
                    case 2:
                        attaquer(j, adversaire);
                        break;
                    default:
                        Log.error("Action joueur impossible à effectuer");
                        break;
                }
            } else {
                attaquer(j, adversaire);
            }
        } else {
            Log.jeu("Attaque impossible pour le moment");
        }


    }

    private void attaquerHeros(Joueur jAttaquant, Joueur adversaire) {
        //Affichage des choix possibles de serviteur pour attaquer le hero averse
        Log.jeu("Veuillez choisir la carte pour attaquer : ");
        jAttaquant.getTerrain().afficherTerrainAttaquePossible();

        //récupération du servietur sélectionné
        int idCarteAttaquante = ServiceGestion.getInputInt(sc, jAttaquant.getTerrain().getServiteursReveillesTerrain().size());
        Serviteur serviteurAttaquant = jAttaquant.getTerrain().getServiteursReveillesTerrain().get(idCarteAttaquante - 1);

        //Supression des points de vie du héro attaqué
        adversaire.getHero().supprimerPV(serviteurAttaquant.getPD());
        Log.jeu("Le héro adverse a perdu " + serviteurAttaquant.getPD() + " PV !");

        //Si serviteur attaquant possède effet vol de vie, on lui redonne les PV correspondant à son attaque
        if (serviteurAttaquant.volerVie()) {
            serviteurAttaquant.ajouterPV(serviteurAttaquant.getPD());
            Log.jeu("Le serviteur gagne " + serviteurAttaquant.getPD() + " PV en volant la vie !");
        }

        //Changement etat serviteur
        serviteurAttaquant.changerEtatDormir();
    }

    /**
     * Méthode pour attaquer une carte adversaire
     *
     * @param j          Joueur attaquant
     * @param adversaire Joueur attaqué
     */
    public void attaquer(Joueur j, Joueur adversaire) {

        // On commence par afficher les cartes pouvant être attaquées
        Log.jeu("Veuillez attaquer une carte : ");
        adversaire.getTerrain().afficherTerrainAttaquePossible();

        //Et a récupérer la carte que le joueur souhaite attaquer
        int idCarteAttaquee = ServiceGestion.getInputInt(sc, adversaire.getTerrain().getServiteursAttaquePossible().size());
        Serviteur serviteurAttaque = adversaire.getTerrain().getServiteursTerrain().get(idCarteAttaquee - 1);

        // On afficher ensuite les serviteurs pouvant être utiliser pour attaquer
        Log.jeu("Veuillez choisir la carte pour attaquer : ");
        int i = 1;
        for (Serviteur s : j.getTerrain().getServiteursReveillesTerrain()) {
            Log.jeu(i + " - " + s.toString());
            i++;
        }

        //Et on récupère le serviteur choisit par le joueur pour attaquer
        int idCarteAttaquante = ServiceGestion.getInputInt(sc, j.getTerrain().getServiteursReveillesTerrain().size());
        Serviteur serviteurAttaquant = j.getTerrain().getServiteursReveillesTerrain().get(idCarteAttaquante - 1);

        serviteurAttaquant.setPV(serviteurAttaquant.getPV() - serviteurAttaque.getPD());
        //si serviteur attaquant n'a plus de pv, il meurt
        if (serviteurAttaquant.getPV() <= 0) {
            j.getTerrain().supprimerCarte(serviteurAttaquant);
            Log.jeu("Le serviteur " + serviteurAttaquant.getNom() + " a été tué");
        }

        serviteurAttaque.setPV(serviteurAttaque.getPV() - serviteurAttaquant.getPD());
        //si serviteur attaquant n'a plus de pv, il meurt
        if (serviteurAttaque.getPV() <= 0) {
            adversaire.getTerrain().supprimerCarte(serviteurAttaque);
            Log.jeu("Le serviteur " + serviteurAttaque.getNom() + " a été tué");
        }


        //Si le serviteur attaquant a l'effet vol de vie, il récupère les PV correspondant à son attaque
        if (serviteurAttaquant.volerVie()) {
            serviteurAttaquant.ajouterPV(serviteurAttaquant.getPD());
            Log.jeu("Le serviteur gagne " + serviteurAttaquant.getPD() + " PV en volant la vie !");
        }
        //Le serviteur attaquant est remis en mode sommeil
        serviteurAttaquant.changerEtatDormir();

    }

    private void instancierJoueurs(App app) {
        app.joueur1 = app.creerJoueur(1);
        Log.changementJoueur();
        app.joueur2 = app.creerJoueur(2);

        int ordreJoueur = new Random().nextInt(2);

        if (ordreJoueur == 1) {
            app.joueur1.initMain(1);
            app.joueur1.setOrdreJoueur(1);
            app.joueur2.initMain(0);
            app.joueur2.setOrdreJoueur(0);
        } else {
            app.joueur1.initMain(0);
            app.joueur1.setOrdreJoueur(0);
            app.joueur2.initMain(1);
            app.joueur2.setOrdreJoueur(1);
        }
    }

    private Joueur creerJoueur(int id) {
        Log.jeu("Joueur " + id + ", Veuillez choisir un nom : ");
        String nomJoueur = ServiceGestion.getInputString(sc);
        Joueur joueur = new Joueur(id, nomJoueur);

        Log.jeu("Veuillez sélectionner la classe de votre héro : 1-Paladin 2-Guerrier 3-Mage");

        HeroFactory f = null;
        int herosInt = ServiceGestion.getInputInt(sc, 3);
        switch (herosInt) {
            case 1:
                f = new PaladinFactory();
                Log.jeu("Vous avez sélectionné le paladin");
                break;
            case 2:
                f = new GuerrierFactory();
                Log.jeu("Vous avez sélectionné le guerrier");
                break;
            case 3:
                f = new MageFactory();
                Log.jeu("Vous avez sélectionné le mage");
                break;
            default:
                Log.jeu("Choix impossible, veuillez recommencer");
                this.creerJoueur(id);
        }
        joueur.setHero(f.creerHeros());

        return joueur;
    }
}
