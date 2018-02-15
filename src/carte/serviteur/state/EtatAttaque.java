package carte.serviteur.state;

import carte.serviteur.Serviteur;
import main.Log;

public class EtatAttaque extends Etat {
    public EtatAttaque(Serviteur serviteur) {
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
