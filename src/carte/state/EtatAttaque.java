package carte.state;

import carte.ServiteurSimple;
import main.Loger;

public class EtatAttaque extends Etat {
	public EtatAttaque(ServiteurSimple serviteur) {
		super(serviteur);
	}

	@Override
	public void dormir() {
		serviteur.changerEtatDormir();
		Loger.info("Le serviteur dort.");
	}
	
	public String toString() {
		return "Peut attaquer";
	}
}
