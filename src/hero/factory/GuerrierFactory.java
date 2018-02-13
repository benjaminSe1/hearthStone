package hero.factory;

import hero.Guerrier;
import hero.Hero;

public class GuerrierFactory implements HeroFactory {

    @Override
    public Hero creerHeros() {
        return new Guerrier(30, 0, 0);
    }

}
