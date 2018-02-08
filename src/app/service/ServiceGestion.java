package app.service;

import app.main.Loger;

import java.util.Scanner;

public class ServiceGestion {
	
	public static int getInputInt(Scanner sc, int max){
		Loger.jeu("Entrez un nombre entre 1 et " + max);
		int res = -1;
		while (true) {
		    while (!sc.hasNextInt()) {
				Loger.jeu("Erreur, entrez un NOMBRE entre 1 et " + max);
				sc.nextLine(); //si c'est pas un int on va à la ligne l'après
		    }
		    res = sc.nextInt();
		    if (res >= 1 && res <= max) {
		        break;
		    }
			Loger.jeu("nombre invalide, entrez un nombre entre 1 et " + max);
		}
		return res;
	}
	
	public static String getInputString(Scanner sc){
		String res = "";
		while (true) {
		    while (!sc.hasNext()) {
				Loger.jeu("Erreur, veuillez entrer une valeur valide");
				sc.nextLine(); //si c'est pas un int on va à la ligne l'après
		    }
		    res = sc.next();
		    if (res != null && !res.equals("")) {
		        break;
		    }
			Loger.jeu("Veuillez entrer une valeur valide");
		}
		return res;
	}
	
}
