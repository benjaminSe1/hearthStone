package main;

import carte.Carte;
import carte.Serviteur;
import service.ListCartes;

import java.util.ArrayList;

public class Test {
	public static void test() {

		ArrayList<Carte> lst = ListCartes.cartesPaladin;
		Carte carte = lst.get(5);
		if(carte.isServiteur()){
			Serviteur s = (Serviteur) carte;
			Loger.info(s.charger() + "");
			Loger.info(s.encourager() + "");
		}
	}
}
