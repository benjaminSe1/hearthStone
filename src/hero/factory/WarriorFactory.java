package hero.factory;

import hero.Hero;
import hero.Warrior;

public class WarriorFactory implements HeroFactory {

    @Override
    public Hero createHero() {
        return new Warrior(30, 0, 0);
    }

}
