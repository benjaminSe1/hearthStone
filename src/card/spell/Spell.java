package card.spell;

import card.Card;
import card.effect.Effect;

public class Spell implements Card {

    private int MP;

    private String name;
    private Effect effect;

    /**
     * Constructeur de la classe sort
     * @param name - le nom du sort
     * @param MP - le coût en mana du sort
     * @param effect - l'effet du sort
     */
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

    /**
     * Méthode qui permet de renvoyer un booléen si la méthode est un sort
     * @return true - la méthode est un sort
     */
    @Override
    public boolean isSpell() {
        return true;
    }

    /**
     * Méthode qui permet de renvoyer un booléen si la méthode est un serviteur
     * @return false - la méthode est un sort
     */
    @Override
    public boolean isMinion() {
        return false;
    }


}
