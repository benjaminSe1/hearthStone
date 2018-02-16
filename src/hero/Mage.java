package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.BouleFeu;
import util.ListCartes;

public class Mage extends Hero {

    public Mage(int PV, int PA, int PM) {
        super(PV, PA, PM, new BouleFeu());
    }

    @Override
    public ArrayList<Card> getCartesHeros() {
        return ListCartes.cartesMage;
    }

    @Override
    public String toString() {
        return "Mage " + super.toString();
    }
}
