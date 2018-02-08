package app.hero.factory;

import app.effect.BouleFeu;
import app.hero.Hero;
import app.hero.Mage;

public class MageFactory implements HerosFactory {

    @Override
    public Hero creerHeros() {
        return new Mage(30, 0, 1, new BouleFeu());
    }

}
