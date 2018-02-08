package app.effectDecorator;

import app.carte.Serviteur;

public class ServiteurVolVie extends ServiteurDecorator {

	public ServiteurVolVie(Serviteur s) {
		super(s);
	}
	
	@Override
	public boolean volerVie(){
		super.volerVie();
		return true;
	}

}
