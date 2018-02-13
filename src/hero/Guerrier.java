package hero;

import carte.Carte;
import carte.effect.Armure;
import service.ListCartes;

import java.util.ArrayList;


public class Guerrier extends Hero {

    public Guerrier(int PV, int PA, int PM) {
        super(PV, PA, PM, new Armure());
    }


    @Override
    public ArrayList<Carte> getCartesHeros() {
        return ListCartes.cartesGuerrier;
    }

    @Override
    public String toString() {
        return "Guerrier " + super.toString();
    }

}
