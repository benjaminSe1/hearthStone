package hero.factory;

import hero.Hero;
import hero.Mage;

public class MageFactory implements HeroFactory {

    @Override
    public Hero creerHeros() {
        return new Mage(30, 0, 0);
    }

}
