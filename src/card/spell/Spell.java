package card.spell;

import card.Card;
import card.effect.Effect;

public class Spell implements Card {
    private int PM;
    private String nom;
    private Effect effect;

    public Spell(String nom, int PM, Effect effect) {
        this.nom = nom;
        this.PM = PM;
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getPM() {
        return PM;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Spell [" + nom + " - " + PM + "]";
    }

    @Override
    public boolean isSort() {
        return true;
    }

    @Override
    public boolean isServiteur() {
        return false;
    }


}
