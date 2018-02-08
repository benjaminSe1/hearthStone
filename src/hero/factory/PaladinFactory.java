package hero.factory;

import effect.Renfort;
import hero.Hero;
import hero.Paladin;

public class PaladinFactory implements HerosFactory {

    @Override
    public Hero creerHeros() {
        return new Paladin(30, 0, 1, new Renfort());
    }

}
