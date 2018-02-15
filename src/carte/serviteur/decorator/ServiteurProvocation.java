package carte.serviteur.decorator;

import carte.serviteur.Serviteur;

public class ServiteurProvocation extends Serviteur {

    Serviteur serviteur;

    public ServiteurProvocation(Serviteur serviteur){
        super(serviteur.getNom(), serviteur.getPM(), serviteur.getPD(), serviteur.getPV());
        this.serviteur = serviteur;
    }

    @Override
    public boolean provoquer() {
        super.provoquer();
        return true;
    }


}
