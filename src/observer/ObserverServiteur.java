package observer;

import main.Loger;

public class ObserverServiteur implements IObserverServiteur{
	
	private Sujet donneesServiteur;
	private int PV;
	private int PD;
	
	public ObserverServiteur(Sujet donneesServiteur){
		this.donneesServiteur = donneesServiteur;
		this.donneesServiteur.enregistrerObs(this);
	}
		
	@Override
	public void actualiser(int PV, int PD) {
		this.PV = PV;
		this.PD = PD;

		Loger.info("[ PV = " + PV + ", PD = " + PD + " ]");
	}

}
