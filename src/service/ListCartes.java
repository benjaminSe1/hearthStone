package service;

import java.util.ArrayList;

import carte.Carte;
import carte.effect.BenedictionPuissance;
import carte.effect.Consecration;
import carte.effect.ExplosionArcane;
import carte.effect.MaitriseBlocage;
import carte.effect.Metamorphose;
import carte.effect.Tourbillon;
import carte.serviteur.Serviteur;
import carte.serviteur.decorator.ServiteurCharge;
import carte.serviteur.decorator.ServiteurEncouragement;
import carte.serviteur.decorator.ServiteurProvocation;
import carte.serviteur.decorator.ServiteurVolVie;
import carte.serviteur.factory.commun.ChefDeRaid;
import carte.serviteur.factory.commun.ChevaucheurDeLoup;
import carte.serviteur.factory.commun.SanglierBrocheroc;
import carte.serviteur.factory.commun.SoldatComteOr;
import carte.serviteur.factory.commun.YetiNoroit;
import carte.serviteur.factory.paladin.ChampionFrisselame;
import carte.serviteur.factory.paladin.RecrueDeLaMainArgent;
import carte.serviteur.factory.special.ImageMiroir;
import carte.serviteur.factory.special.Mouton;
import carte.serviteur.factory.warrior.AvocatCommisOffice;
import carte.sort.Sort;

public class ListCartes {

    public static ArrayList<Carte> cartesCommunes = new ArrayList<>();
    public static ArrayList<Carte> cartesPaladin = new ArrayList<>();
    public static ArrayList<Carte> cartesMage = new ArrayList<>();
    public static ArrayList<Carte> cartesGuerrier = new ArrayList<>();

    public static RecrueDeLaMainArgent carteRenfort = new RecrueDeLaMainArgent();
    public static Serviteur carteMiroir = new ServiteurProvocation(new ImageMiroir());
    public static Mouton carteMetamorphose = new Mouton();

    static {
        Serviteur sa1 = new SanglierBrocheroc();
        cartesCommunes.add(sa1);
        Serviteur sa2 = new SoldatComteOr();
        cartesCommunes.add(sa2);
        Serviteur sa3 = new ServiteurCharge(new ChevaucheurDeLoup());
        cartesCommunes.add(sa3);
        Serviteur sa4 = new ServiteurEncouragement(new ChefDeRaid());
        cartesCommunes.add(sa4);
        Serviteur sa5 = new YetiNoroit();
        cartesCommunes.add(sa5);

        cartesPaladin.addAll(cartesCommunes);
        cartesMage.addAll(cartesCommunes);
        cartesGuerrier.addAll(cartesCommunes);

        Sort sort1 = new Sort("Image miroir", 1, new carte.effect.ImageMiroir());
        cartesMage.add(sort1);
        Sort sort2 = new Sort("Explosion des arcanes", 2, new ExplosionArcane());
        cartesMage.add(sort2);
        Sort sort3 = new Sort("Métamorphose", 4, new Metamorphose());
        cartesMage.add(sort3);

        Serviteur sa6 = new ServiteurVolVie(new ServiteurCharge(new ChampionFrisselame()));
        cartesPaladin.add(sa6);
        Sort sort4 = new Sort("Bénédiction de puissance", 1, new BenedictionPuissance());
        cartesPaladin.add(sort4);
        Sort sort5 = new Sort("Consécration", 4, new Consecration());
        cartesPaladin.add(sort5);

        Sort sort6 = new Sort("Tourbillon", 1, new Tourbillon());
        cartesGuerrier.add(sort6);
        Serviteur sa7 = new AvocatCommisOffice();
        cartesGuerrier.add(sa7);
        Sort sort7 = new Sort("Maîtrise du blocage", 3, new MaitriseBlocage());
        cartesGuerrier.add(sort7);

    }
}
