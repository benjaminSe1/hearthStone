package hero.factory;

import hero.Hero;
import hero.Paladin;

public class PaladinFactory implements HeroFactory {

    @Override
    public Hero createHero() {
        return new Paladin(30, 0, 0);
    }

}
