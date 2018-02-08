package app.hero.factory;

import app.effect.Armure;
import app.hero.Guerrier;
import app.hero.Hero;

public class GuerrierFactory implements HerosFactory {

    @Override
    public Hero creerHeros() {
        return new Guerrier(30, 0, 1, new Armure());
    }

}
