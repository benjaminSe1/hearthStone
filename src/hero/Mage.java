package hero;

import carte.Carte;
import carte.effect.BouleFeu;
import service.ListCartes;

import java.util.ArrayList;

public class Mage extends Hero {

    public Mage(int PV, int PA, int PM) {
        super(PV, PA, PM, new BouleFeu());
    }

    @Override
    public ArrayList<Carte> getCartesHeros() {
        return ListCartes.cartesMage;
    }

    @Override
    public String toString() {
        return "Mage " + super.toString();
    }
}
