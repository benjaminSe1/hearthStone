package hero.factory;

import hero.Hero;
import hero.Mage;

public class MageFactory implements HeroFactory {

    /**
     * Méthode permettant de créer un Hero mage
     * @return - le nouveau Hero Mage
     */
    @Override
    public Hero createHero() {
        return new Mage(30, 0, 0);
    }

}
