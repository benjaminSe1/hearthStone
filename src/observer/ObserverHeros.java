package observer;

import main.Loger;

public class ObserverHeros implements IObserverHeros{
	
	private Sujet donneesHeros;
	private int PV;
	private int PA;
	private int PM;
	
	public ObserverHeros(Sujet donneesHeros){
		this.donneesHeros = donneesHeros;
		this.donneesHeros.enregistrerObs(this);
	}

	@Override
	public void actualiser(int PV, int PA, int PM) {
		this.PV = PV;
		this.PA = PA;
		this.PM = PM;

		Loger.info("[ PV = " + PV + ", PA = " + PA + ", PM = " + PM + " ]");
	}

}
