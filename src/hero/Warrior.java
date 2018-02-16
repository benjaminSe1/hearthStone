package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.Armor;
import util.CardList;

public class Warrior extends Hero {

    public Warrior(int HP, int AP, int MP) {
        super(HP, AP, MP, new Armor());
    }


    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.warriorCards;
    }

    @Override
    public String toString() {
        return "Guerrier " + super.toString();
    }

}
