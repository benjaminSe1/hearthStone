package carte;

import observer.Observer;

public interface Serviteur extends Carte{

	public int getPV();

	public int getPD();

	public int getPM();

	public String getNom();

	public String toString();
	
	public void changerEtatAttaquer();
	
	public void changerEtatDormir();

	public void enregistrerObs(Observer o);

	public void supprimerObs(Observer o);

	public void notifierObs();
	
	public void setDonnees(int PV, int PD);
	
	public boolean charger();
	
	public boolean volerVie();
	
	public boolean encourager();
	
	public boolean provoquer();
		
}
