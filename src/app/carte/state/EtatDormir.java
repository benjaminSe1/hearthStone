package app.carte.state;

import app.carte.ServiteurSimple;
import app.main.Loger;

public class EtatDormir extends Etat {

	public EtatDormir(ServiteurSimple serviteur) {
		super(serviteur);
	}

	@Override
	public void attaquer() {
		serviteur.changerEtatAttaquer();
		Loger.info("Le serviteur peut attaquer");
	}
	
	public String toString() {
		return "dort";
	}
}
