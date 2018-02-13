package carte.state;

import carte.ServiteurSimple;
import main.Log;

public class EtatDormir extends Etat {

    public EtatDormir(ServiteurSimple serviteur) {
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
