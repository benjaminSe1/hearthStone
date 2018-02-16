package hero.observer;

public interface Sujet {

    void attachObs(Observer o);

    void detachObs(Observer o);

    void notifyObs();
}
