package hero;

import card.Card;
import card.CardList;
import card.effect.Armor;

import java.util.ArrayList;

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
