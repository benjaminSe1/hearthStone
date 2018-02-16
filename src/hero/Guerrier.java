package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.Armor;
import util.CardList;


public class Guerrier extends Hero {
    private ArrayList<Card> cartesGuerrier;

    public Guerrier(int PV, int PA, int PM) {
        super(PV, PA, PM, new Armor());
        cartesGuerrier = CardList.warriorCards;
    }


    @Override
    public ArrayList<Card> getCartesHeros() {
        return CardList.warriorCards;
    }

    @Override
    public String toString() {
        return "Guerrier " + super.toString();
    }

}
