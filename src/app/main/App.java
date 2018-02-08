package app.main;

import java.util.Scanner;

import app.board.Joueur;
import app.heros.factory.GuerrierFactory;
import app.heros.factory.HerosFactory;
import app.heros.factory.MageFactory;
import app.heros.factory.PaladinFactory;
import app.service.ServiceGestion;

public class App {
	Joueur joueur1;
	Joueur joueur2;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Test.test();
		App app = new App();
		
		Log.jeu("Bienvenue sur le mini hearthstone :)");
		
		//app.instancierJoueurs(app);
		
		
	}
	
	private void instancierJoueurs(App app){
		app.joueur1 = app.creerJoueur(1);
		Log.line();
		app.joueur2 = app.creerJoueur(2);
	}
	
	private Joueur creerJoueur(int id){
		Log.jeu("Joueur "+id+", quel est votre nom ?");
		String nomJoueur = ServiceGestion.getInputString(sc);
		Joueur joueur = new Joueur(id, nomJoueur);
		
		Log.jeu("Veuillez sélectionner la classe de votre héros : 1-Paladin 2-Guerrier 3-Mage");
		
		HerosFactory f = null;
		int herosInt = ServiceGestion.getInputInt(sc, 3);
		switch (herosInt){
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
		}
		joueur.getBoard().setHeros(f.creerHeros());
		
		return joueur;
	}
}
