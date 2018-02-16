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

    public static ArrayList<Card> commonCards = new ArrayList<>();
    public static ArrayList<Card> paladinCards = new ArrayList<>();
    public static ArrayList<Card> mageCards = new ArrayList<>();
    public static ArrayList<Card> warriorCards = new ArrayList<>();

    public static Minion silverHandRecruit = new SilverHandRecruit();
    public static Minion mirrorImage = new MinionTaunt(new MirrorImage());
    public static Minion sheep = new Sheep();

    static {
        Minion stonetuskBoar = new StonetuskBoar();
        commonCards.add(stonetuskBoar);
        Minion goldshireFootman = new GoldshireFootman();
        commonCards.add(goldshireFootman);
        Minion minionCharge = new MinionCharge(new WolfRider());
        commonCards.add(minionCharge);
        Minion minionEnhanced = new MinionEnhanced(new RaidLeader());
        commonCards.add(minionEnhanced);
        Minion chillwindYeti = new ChillwindYeti();
        commonCards.add(chillwindYeti);

        paladinCards.addAll(commonCards);
        mageCards.addAll(commonCards);
        warriorCards.addAll(commonCards);

        Spell spell1 = new Spell("Image miroir", 1, new card.effect.MirrorImage());
        mageCards.add(spell1);
        Spell spell2 = new Spell("Explosion des arcanes", 2, new ArcaneExplosion());
        mageCards.add(spell2);
        Spell spell3 = new Spell("Métamorphose", 4, new Polymorph());
        mageCards.add(spell3);

        Minion minionLifeSteal = new MinionLifeSteal(new MinionCharge(new ChillbladeChampion()));
        paladinCards.add(minionLifeSteal);
        Spell spell4 = new Spell("Bénédiction de puissance", 1, new BlessingOfMight());
        paladinCards.add(spell4);
        Spell spell5 = new Spell("Consécration", 4, new Consecration());
        paladinCards.add(spell5);

        Spell spell6 = new Spell("Whirlwind", 1, new Whirlwind());
        warriorCards.add(spell6);
        Minion publicDefender = new PublicDefender();
        warriorCards.add(publicDefender);
        Spell spell7 = new Spell("Maîtrise du blocage", 3, new ShieldBlock());
        warriorCards.add(spell7);

    }
}
