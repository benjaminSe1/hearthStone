package card.minion.decorator;

import card.minion.Serviteur;

/**
 * Created by E149769S on 15/02/18.
 */
public abstract class ServiteurDecorator extends Serviteur{

    Serviteur serviteur;

    public ServiteurDecorator(Serviteur serviteur){
        super(serviteur.getNom(), serviteur.getPM(), serviteur.getPD(), serviteur.getPV());
        this.serviteur = serviteur;
    }
}
