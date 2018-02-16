package card.minion.decorator;

import card.minion.Serviteur;

public class ServiteurCharge extends Serviteur {

    Serviteur serviteur;

    public ServiteurCharge(Serviteur serviteur){
        super(serviteur.getNom(), serviteur.getPM(), serviteur.getPD(), serviteur.getPV());
        this.serviteur = serviteur;
    }

    @Override
    public boolean charger() {
        super.charger();
        return true;
    }

}
