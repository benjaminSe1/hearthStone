package hero.observer;

public interface Sujet {
    void enregistrerObs(Observer o);

    void supprimerObs(Observer o);

    void notifierObs();
}
