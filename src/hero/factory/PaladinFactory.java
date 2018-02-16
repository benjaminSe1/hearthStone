package hero.factory;

import hero.Hero;
import hero.Paladin;

public class PaladinFactory implements HeroFactory {

    /**
     * Méthode permettant de créer un Hero Paladin
     * @return - le nouveau Hero Paladin
     */
    @Override
    public Hero createHero() {
        return new Paladin(30, 0, 0);
    }

}
