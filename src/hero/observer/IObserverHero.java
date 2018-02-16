package hero.observer;

public interface IObserverHero extends Observer {

    /**
     * Permet de mettre à jour les informations d'un Hero
     * @param HP - Les points de vie du Hero
     * @param AP - Les points d'armure du Hero
     * @param MP - Les points de mana du Hero
     */
    void update(int HP, int AP, int MP);
}
