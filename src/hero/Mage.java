package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.FireBlast;
import util.CardList;

public class Mage extends Hero {

    public Mage(int PV, int PA, int PM) {
        super(PV, PA, PM, new FireBlast());
    }

    @Override
    public ArrayList<Card> getCartesHeros() {
        return CardList.mageCards;
    }

    @Override
    public String toString() {
        return "Mage " + super.toString();
    }
}
