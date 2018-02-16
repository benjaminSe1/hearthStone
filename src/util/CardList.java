package util;

import java.util.ArrayList;

import card.Card;
import card.effect.*;
import card.minion.Minion;
import card.minion.decorator.MinionCharge;
import card.minion.decorator.MinionEnhanced;
import card.minion.decorator.MinionTaunt;
import card.minion.decorator.MinionLifeSteal;
import card.minion.common.RaidLeader;
import card.minion.common.WolfRider;
import card.minion.common.StonetuskBoar;
import card.minion.common.GoldshireFootman;
import card.minion.common.ChillwindYeti;
import card.minion.paladin.ChillbladeChampion;
import card.minion.paladin.SilverHandRecruit;
import card.minion.special.MirrorImage;
import card.minion.special.Sheep;
import card.minion.warrior.PublicDefender;
import card.spell.Spell;

public class CardList {

    public static ArrayList<Card> cartesCommunes = new ArrayList<>();
    public static ArrayList<Card> cartesPaladin = new ArrayList<>();
    public static ArrayList<Card> cartesMage = new ArrayList<>();
    public static ArrayList<Card> cartesGuerrier = new ArrayList<>();

    public static SilverHandRecruit carteRenfort = new SilverHandRecruit();
    public static Minion carteMiroir = new MinionTaunt(new MirrorImage());
    public static Sheep carteMetamorphose = new Sheep();

    static {
        Minion sa1 = new StonetuskBoar();
        cartesCommunes.add(sa1);
        Minion sa2 = new GoldshireFootman();
        cartesCommunes.add(sa2);
        Minion sa3 = new MinionCharge(new WolfRider());
        cartesCommunes.add(sa3);
        Minion sa4 = new MinionEnhanced(new RaidLeader());
        cartesCommunes.add(sa4);
        Minion sa5 = new ChillwindYeti();
        cartesCommunes.add(sa5);

        cartesPaladin.addAll(cartesCommunes);
        cartesMage.addAll(cartesCommunes);
        cartesGuerrier.addAll(cartesCommunes);

        Spell spell1 = new Spell("Image miroir", 1, new card.effect.MirrorImage());
        cartesMage.add(spell1);
        Spell spell2 = new Spell("Explosion des arcanes", 2, new ArcaneExplosion());
        cartesMage.add(spell2);
        Spell spell3 = new Spell("Métamorphose", 4, new Polymorph());
        cartesMage.add(spell3);

        Minion sa6 = new MinionLifeSteal(new MinionCharge(new ChillbladeChampion()));
        cartesPaladin.add(sa6);
        Spell spell4 = new Spell("Bénédiction de puissance", 1, new BlessingOfMight());
        cartesPaladin.add(spell4);
        Spell spell5 = new Spell("Consécration", 4, new Consecration());
        cartesPaladin.add(spell5);

        Spell spell6 = new Spell("Whirlwind", 1, new Whirlwind());
        cartesGuerrier.add(spell6);
        Minion sa7 = new PublicDefender();
        cartesGuerrier.add(sa7);
        Spell spell7 = new Spell("Maîtrise du blocage", 3, new ShieldBlock());
        cartesGuerrier.add(spell7);

    }
}
