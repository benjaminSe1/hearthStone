package main;

import board.Joueur;
import hero.factory.GuerrierFactory;
import hero.factory.HerosFactory;
import hero.factory.MageFactory;
import hero.factory.PaladinFactory;
import service.ServiceGestion;

import java.util.Scanner;

public class App {
	private static Scanner sc = new Scanner(System.in);
	Joueur joueur1;
	Joueur joueur2;
	
	public static void main(String[] args) {
		Test.test();
		App app = new App();

		Loger.jeu("Bienvenue sur le mini hearthstone :)");
		
		//app.instancierJoueurs(app);
		
		
	}
	
	private void instancierJoueurs(App app){
		app.joueur1 = app.creerJoueur(1);
		Loger.line();
		app.joueur2 = app.creerJoueur(2);
	}
	
	private Joueur creerJoueur(int id){
		Loger.jeu("Joueur " + id + ", quel est votre nom ?");
		String nomJoueur = ServiceGestion.getInputString(sc);
		Joueur joueur = new Joueur(id, nomJoueur, null);

		Loger.jeu("Veuillez sélectionner la classe de votre héros : 1-Paladin 2-Guerrier 3-Mage");
		
		HerosFactory f = null;
		int herosInt = ServiceGestion.getInputInt(sc, 3);
		switch (herosInt){
		case 1:
			f = new PaladinFactory();
			Loger.jeu("Vous avez sélectionné le paladin");
			break;
		case 2:
			f = new GuerrierFactory();
			Loger.jeu("Vous avez sélectionné le guerrier");
			break;
		case 3: 
			f = new MageFactory();
			Loger.jeu("Vous avez sélectionné le mage");
			break;
		}
		//joueur.getBoard().setHero(f.creerHeros());
		
		return joueur;
	}
}
