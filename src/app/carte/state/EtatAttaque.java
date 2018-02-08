package app.carte.state;

import app.carte.ServiteurSimple;
import app.main.Log;

public class EtatAttaque extends Etat {
	public EtatAttaque(ServiteurSimple serviteur) {
		super(serviteur);
	}

	@Override
	public void dormir() {
		serviteur.changerEtatDormir();
		Log.info("Le serviteur dort.");
	}
	
	public String toString() {
		return "Peut attaquer";
	}
}
