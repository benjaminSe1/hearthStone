package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.Armure;
import util.ListCartes;


public class Guerrier extends Hero {
    private ArrayList<Card> cartesGuerrier;

    public Guerrier(int PV, int PA, int PM) {
        super(PV, PA, PM, new Armure());
        cartesGuerrier = ListCartes.cartesGuerrier;
    }


    @Override
    public ArrayList<Card> getCartesHeros() {
        return ListCartes.cartesGuerrier;
    }

    @Override
    public String toString() {
        return "Guerrier " + super.toString();
    }

}
