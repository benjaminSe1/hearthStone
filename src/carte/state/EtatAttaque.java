package carte.state;

import carte.ServiteurSimple;
import main.Log;

public class EtatAttaque extends Etat {
    public EtatAttaque(ServiteurSimple serviteur) {
        super(serviteur);
    }

    @Override
    public void dormir() {
        serviteur.changerEtatDormir();
        Log.info("Le serviteur dort.");
    }

    @Override
    public boolean peutAttaquer() {
        return true;
    }

    public String toString() {
        return "Peut attaquer";
    }
}
