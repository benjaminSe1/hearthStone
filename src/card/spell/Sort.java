package card.spell;

import card.Card;
import card.effect.Effet;

public class Sort implements Card {
    private int PM;
    private String nom;
    private Effet effet;

    public Sort(String nom, int PM, Effet effet) {
        this.nom = nom;
        this.PM = PM;
        this.effet = effet;
    }

    public Effet getEffet() {
        return effet;
    }

    public int getPM() {
        return PM;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Sort [" + nom + " - " + PM + "]";
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
