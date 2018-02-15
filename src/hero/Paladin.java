package hero;

import java.util.ArrayList;

import carte.Carte;
import carte.effect.Renfort;
import service.ListCartes;

public class Paladin extends Hero {

    public Paladin(int PV, int PA, int PM) {
        super(PV, PA, PM, new Renfort());
    }

    @Override
    public ArrayList<Carte> getCartesHeros() {
        return ListCartes.cartesPaladin;
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}
