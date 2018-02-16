package card.spell;

import card.Card;
import card.effect.Effect;

public class Spell implements Card {

    private int MP;

    private String name;
    private Effect effect;

    public Spell(String name, int MP, Effect effect) {
        this.name = name;
        this.MP = MP;
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getMP() {
        return MP;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sort [" + name + " - " + MP + "]";
    }

    @Override
    public boolean isSpell() {
        return true;
    }

    @Override
    public boolean isMinion() {
        return false;
    }


}
