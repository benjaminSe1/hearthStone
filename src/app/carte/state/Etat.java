package app.carte.state;

import app.carte.ServiteurSimple;

public abstract class Etat {
	protected ServiteurSimple serviteur;
	
	public Etat(ServiteurSimple serviteur) {
		this.serviteur = serviteur;
	}
	
	public void attaquer() {};
	public void dormir() {};
}
