package card.minion.decorator;

import card.minion.Serviteur;

public class ServiteurEncouragement extends Serviteur {

    Serviteur serviteur;

    public ServiteurEncouragement(Serviteur serviteur){
        super(serviteur.getNom(), serviteur.getPM(), serviteur.getPD(), serviteur.getPV());
        this.serviteur = serviteur;

    }
    @Override
    public boolean encourager() {
        super.encourager();
        return true;
    }


}
