package app.heros;

import java.util.ArrayList;

import app.effect.Effet;
import app.main.Log;
import app.observer.IObserverHeros;
import app.observer.Observer;
import app.observer.Sujet;

public abstract class Heros implements Sujet{
	private int PV; //Points de vie
	private int PA; // Point d'armure
	private int PM; //Points de mana
	private Effet effet;
	private ArrayList<IObserverHeros> observers;
	
	public Heros (int PV, int PA, int PM, Effet effet){
		this.effet = effet;
		this.observers = new ArrayList<>();
		setDonnees(PV, PA, PM);
	}

	public int getPV() {
		return PV;
	}

	public int getPA() {
		return PA;
	}

	public int getPM() {
		return PM;
	}

	public Effet getEffet() {
		return effet;
	}
	
	public void activerEffet(){
		this.effet.activerEffet();
	}

	@Override
	public String toString() {
		return "Heros [PV=" + PV + ", PA=" + PA + ", PM=" + PM + ", effet=" + effet + "]";
	}
	
	//Methodes de l'observer Heros
	@Override
	public void enregistrerObs(Observer o) {
		if(o instanceof IObserverHeros){
			observers.add((IObserverHeros) o);
		} else {
			Log.error("l'observeur n'a pas pu être ajouté");
		}
	}

	@Override
	public void supprimerObs(Observer o) {
		if(o instanceof IObserverHeros){
			observers.remove((IObserverHeros) o);
		} else {
			Log.error("l'observeur n'a pas pu être supprimé");
		}
	}

	@Override
	public void notifierObs() {
		for(IObserverHeros o : this.observers){
			o.actualiser(PV, PA, PM);
		}
	}
	
	public void setDonnees(int PV, int PA, int PM){
		this.PV = PV;
		this.PA = PA;
		this.PM = PM;
		
		notifierObs();
	}
}
