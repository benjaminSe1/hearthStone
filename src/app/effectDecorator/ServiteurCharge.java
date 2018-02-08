package app.effectDecorator;

import app.carte.Serviteur;

public class ServiteurCharge extends ServiteurDecorator{

	public ServiteurCharge(Serviteur s) {
		super(s);
	}
	
	@Override
	public boolean charger(){
		super.charger();
		return true;
	}

}
