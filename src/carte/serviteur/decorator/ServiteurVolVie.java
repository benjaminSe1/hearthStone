package carte.serviteur.decorator;

import carte.serviteur.Serviteur;

public class ServiteurVolVie extends Serviteur {

    Serviteur serviteur;

    public ServiteurVolVie(Serviteur serviteur){
        super(serviteur.getNom(), serviteur.getPM(), serviteur.getPD(), serviteur.getPV());
        this.serviteur = serviteur;
    }

    @Override
    public boolean volerVie() {
        super.volerVie();
        return true;
    }

}
