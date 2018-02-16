package hero.observer;

public interface Sujet {

    /**
     * Permet d'enregistrer un observer
     * @param o - L'observer
     */
    void attachObs(Observer o);

    /**
     * Permet de retirer un observer
     * @param o - L'observer
     */
    void detachObs(Observer o);

    /**
     * Permet de notifier les observers
     */
    void notifyObs();
}
