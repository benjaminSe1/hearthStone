package card.minion.decorator;

import card.minion.Serviteur;

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
