package carte.serviteur.decorator;

import carte.serviteur.Serviteur;

public class ServiteurProvocation extends ServiteurDecorator {

    public ServiteurProvocation(Serviteur s) {
        super(s);
    }

    @Override
    public boolean provoquer() {
        super.provoquer();
        return true;
    }


}
