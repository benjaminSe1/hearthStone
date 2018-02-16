package hero.factory;

import hero.Hero;

public interface HeroFactory {

    /**
     * Méthode qui permet d'implémenter la factory de hero
     * @return Hero - Un nouveau hero
     */
    Hero createHero();
}
