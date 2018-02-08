package app.carte;

import app.carte.state.Etat;
import app.carte.state.EtatAttaque;
import app.carte.state.EtatDormir;
import app.main.Loger;
import app.observer.IObserverServiteur;
import app.observer.Observer;
import app.observer.Sujet;

import java.util.ArrayList;

public class ServiteurSimple implements Sujet, Serviteur{

	private int PM;
	private String nom;
	private int PV;
	private int PD;
	
	private Etat etatDormir;
	private Etat etatAttaque;
	private Etat etatCourant;
	
	private ArrayList<IObserverServiteur> observers;
	
	public ServiteurSimple(String nom, int PM, int PD, int PV) {
		this.PM = PM;
		this.nom = nom;
		//init du state
		this.etatAttaque = new EtatAttaque(this);
		this.etatDormir = new EtatDormir(this);
		this.etatCourant = this.etatDormir;

		//init de l'app.observer
		this.observers = new ArrayList<>();
		setDonnees(PV, PD);
	}

	public int getPV() {
		return PV;
	}

	public int getPD() {
		return PD;
	}

	public int getPM() {
		return PM;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Serviteur ["+ nom + " - " + PM + "/" + PD + "/" + PV + " - " + etatCourant + "]";
	}
	
	//méthodes du state
	
	public void changerEtatAttaquer() {
		etatCourant = etatAttaque;
	}
	
	public void changerEtatDormir() {
		etatCourant = etatDormir;
	}

	//méthodes de l'app.observer

	@Override
	public void enregistrerObs(Observer o) {
		if(o instanceof IObserverServiteur){
			observers.add((IObserverServiteur) o);
		} else {
			Loger.error("l'observeur n'a pas pu être ajouté");
		}
	}

	@Override
	public void supprimerObs(Observer o) {
		if(o instanceof IObserverServiteur){
			observers.remove((IObserverServiteur) o);
		} else {
			Loger.error("l'observeur n'a pas pu être supprimé");
		}
	}

	@Override
	public void notifierObs() {
		for(IObserverServiteur o : this.observers){
			o.actualiser(PV, PD);
		}
	}
	
	public void setDonnees(int PV, int PD){
		this.PV = PV;
		this.PD = PD;
		
		notifierObs();
	}

	@Override
	public boolean charger() {
		return false;
	}

	@Override
	public boolean volerVie() {
		return false;
	}

	@Override
	public boolean encourager() {
		return false;
	}

	@Override
	public boolean provoquer() {
		return false;
	}

	@Override
	public boolean isSort() {
		return false;
	}

	@Override
	public boolean isServiteur() {
		return true;
	}

}
