package hero;

import card.Card;
import card.CardList;
import card.effect.FireBlast;

import java.util.ArrayList;

public class Mage extends Hero {

    public Mage(int HP, int AP, int MP) {
        super(HP, AP, MP, new FireBlast());
    }

    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.mageCards;
    }

    @Override
    public String toString() {
        return "Mage " + super.toString();
    }
}
