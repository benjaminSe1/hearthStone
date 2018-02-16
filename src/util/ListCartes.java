package util;

import java.util.ArrayList;

import card.Card;
import card.effect.BenedictionPuissance;
import card.effect.Consecration;
import card.effect.ExplosionArcane;
import card.effect.MaitriseBlocage;
import card.effect.Metamorphose;
import card.effect.Tourbillon;
import card.minion.Serviteur;
import card.minion.decorator.ServiteurCharge;
import card.minion.decorator.ServiteurEncouragement;
import card.minion.decorator.ServiteurProvocation;
import card.minion.decorator.ServiteurVolVie;
import card.minion.commun.ChefDeRaid;
import card.minion.commun.ChevaucheurDeLoup;
import card.minion.commun.SanglierBrocheroc;
import card.minion.commun.SoldatComteOr;
import card.minion.commun.YetiNoroit;
import card.minion.paladin.ChampionFrisselame;
import card.minion.paladin.RecrueDeLaMainArgent;
import card.minion.special.ImageMiroir;
import card.minion.special.Mouton;
import card.minion.warrior.AvocatCommisOffice;
import card.spell.Sort;

public class ListCartes {

    public static ArrayList<Card> cartesCommunes = new ArrayList<>();
    public static ArrayList<Card> cartesPaladin = new ArrayList<>();
    public static ArrayList<Card> cartesMage = new ArrayList<>();
    public static ArrayList<Card> cartesGuerrier = new ArrayList<>();

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

        Sort sort1 = new Sort("Image miroir", 1, new card.effect.ImageMiroir());
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
