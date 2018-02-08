package app.hero.factory;

import app.effect.Renfort;
import app.hero.Hero;
import app.hero.Paladin;

public class PaladinFactory implements HerosFactory {

    @Override
    public Hero creerHeros() {
        return new Paladin(30, 0, 1, new Renfort());
    }

}
