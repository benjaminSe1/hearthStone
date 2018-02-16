package hero.factory;

import hero.Hero;
import hero.Warrior;

public class WarriorFactory implements HeroFactory {

    /**
     * Méthode permettant de créer un Hero Warrior
     * @return - le nouveau Hero Warrior
     */
    @Override
    public Hero createHero() {
        return new Warrior(30, 0, 0);
    }

}
