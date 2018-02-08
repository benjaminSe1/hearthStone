package hero.factory;

import effect.BouleFeu;
import hero.Hero;
import hero.Mage;

public class MageFactory implements HerosFactory {

    @Override
    public Hero creerHeros() {
        return new Mage(30, 0, 1, new BouleFeu());
    }

}
