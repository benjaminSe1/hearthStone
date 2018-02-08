package service;

import carte.Carte;
import carte.Serviteur;
import carte.ServiteurSimple;
import carte.Sort;
import effect.*;
import effectDecorator.ServiteurCharge;
import effectDecorator.ServiteurEncouragement;
import effectDecorator.ServiteurProvocation;
import effectDecorator.ServiteurVolVie;

import java.util.ArrayList;

public class ListCartes {
	
	public static ArrayList<Carte> cartesCommunes = new ArrayList<>();
	public static ArrayList<Carte> cartesPaladin = new ArrayList<>();
	public static ArrayList<Carte> cartesMage = new ArrayList<>();
	public static ArrayList<Carte> cartesGuerrier = new ArrayList<>();
	
	static{
		Serviteur sa1 = new ServiteurSimple("Sanglier brocheroc", 1,1,1);
		cartesCommunes.add(sa1);	
		Serviteur sa2 = new ServiteurProvocation(new ServiteurSimple("Soldat du compté-de-l\'or", 1, 1, 2));
		cartesCommunes.add(sa2);
		Serviteur sa3 = new ServiteurCharge(new ServiteurSimple("Chevaucher de loup", 3, 3, 1));
		cartesCommunes.add(sa3);
		Serviteur sa4 = new ServiteurEncouragement(new ServiteurSimple("Chef de raid", 3, 2, 2));
		cartesCommunes.add(sa4);
		Serviteur sa5 = new ServiteurSimple("Yéti noroit", 4, 4, 5);
		cartesCommunes.add(sa5);
		
		cartesPaladin.addAll(cartesCommunes);
		cartesMage.addAll(cartesCommunes);
		cartesGuerrier.addAll(cartesCommunes);
		
		Sort sort1 = new Sort("Image miroir", 1, new ImageMiroir());
		cartesMage.add(sort1);
		Sort sort2 = new Sort("Explosion des arcanes", 2, new ExplosionArcane());
		cartesMage.add(sort2);
		Sort sort3 = new Sort("Métamorphose", 4, new Metamorphose());
		cartesMage.add(sort3);
		
		Serviteur sa6 = new ServiteurVolVie(new ServiteurCharge(new ServiteurSimple("Champion frisselame", 4, 3, 2)));
		cartesPaladin.add(sa6);
		Sort sort4 = new Sort("Bénédiction de puissance", 1, new BenedictionPuissance());
		cartesPaladin.add(sort4);
		Sort sort5 = new Sort("Consécration", 4, new Consecration());
		cartesPaladin.add(sort5);
		
		Sort sort6 = new Sort("Tourbillon", 1, new Tourbillon());
		cartesGuerrier.add(sort6);
		Serviteur sa7 = new ServiteurSimple("Avocat commis d\'office", 2, 0, 7);
		cartesGuerrier.add(sa7);
		Sort sort7 = new Sort("Maîtrise du blocage", 3, new MaitriseBlocage());
		cartesGuerrier.add(sort7);
		
	}
}
