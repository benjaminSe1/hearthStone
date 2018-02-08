package app.effectDecorator;

import app.carte.Serviteur;

public class ServiteurEncouragement extends ServiteurDecorator {

	public ServiteurEncouragement(Serviteur s) {
		super(s);
	}
	
	@Override
	public boolean encourager(){
		super.encourager();
		return true;
	}
	

}
