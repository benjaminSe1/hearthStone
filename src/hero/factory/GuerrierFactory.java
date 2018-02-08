package hero.factory;

import effect.Armure;
import hero.Guerrier;
import hero.Hero;

public class GuerrierFactory implements HerosFactory {

    @Override
    public Hero creerHeros() {
        return new Guerrier(30, 0, 1, new Armure());
    }

}
