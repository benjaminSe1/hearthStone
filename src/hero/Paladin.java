package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.Renfort;
import util.ListCartes;

public class Paladin extends Hero {

    public Paladin(int PV, int PA, int PM) {
        super(PV, PA, PM, new Renfort());
    }

    @Override
    public ArrayList<Card> getCartesHeros() {
        return ListCartes.cartesPaladin;
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}
