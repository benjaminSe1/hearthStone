package card.minion.state;

import card.minion.Serviteur;
import util.MyLogger;

public class EtatDormir extends Etat {

    public EtatDormir(Serviteur serviteur) {
        super(serviteur);
    }

    @Override
    public void attaquer() {
        serviteur.changerEtatAttaquer();
        MyLogger.info("Le minion peut attaquer");
    }

    @Override
    public boolean peutAttaquer() {
        return false;
    }

    public String toString() {
        return "dort";
    }
}
