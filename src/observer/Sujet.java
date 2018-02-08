package observer;

public interface Sujet {
	public void enregistrerObs(Observer o);
	public void supprimerObs(Observer o);
	public void notifierObs();
}
