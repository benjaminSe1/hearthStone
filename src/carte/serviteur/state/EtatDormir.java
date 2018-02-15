package carte.serviteur.state;

import carte.serviteur.Serviteur;
import main.Log;

public class EtatDormir extends Etat {

    public EtatDormir(Serviteur serviteur) {
        super(serviteur);
    }

    @Override
    public void attaquer() {
        serviteur.changerEtatAttaquer();
        Log.info("Le serviteur peut attaquer");
    }

    @Override
    public boolean peutAttaquer() {
        return false;
    }

    public String toString() {
        return "dort";
    }
}
