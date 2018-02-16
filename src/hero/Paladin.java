package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.Reinforce;
import util.CardList;

public class Paladin extends Hero {

    public Paladin(int PV, int PA, int PM) {
        super(PV, PA, PM, new Reinforce());
    }

    @Override
    public ArrayList<Card> getCartesHeros() {
        return CardList.paladinCards;
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}
