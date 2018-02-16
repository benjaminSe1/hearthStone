package card.minion.state;

import card.minion.Serviteur;
import util.MyLogger;

public class EtatAttaque extends Etat {
    public EtatAttaque(Serviteur serviteur) {
        super(serviteur);
    }

    @Override
    public void dormir() {
        serviteur.changerEtatDormir();
        MyLogger.info("Le minion dort.");
    }

    @Override
    public boolean peutAttaquer() {
        return true;
    }

    public String toString() {
        return "Peut attaquer";
    }
}
