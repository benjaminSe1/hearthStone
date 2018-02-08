package app.main;

import java.util.ArrayList;

import app.carte.Carte;
import app.carte.Serviteur;
import app.service.ListCartes;

public class Test {
	public static void test() {

		ArrayList<Carte> lst = ListCartes.cartesPaladin;
		Carte carte = lst.get(5);
		if(carte.isServiteur()){
			Serviteur s = (Serviteur) carte;
			Log.info(s.charger() + "");
			Log.info(s.encourager() + "");
		}
	}
}
