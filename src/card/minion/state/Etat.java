package card.minion.state;

import card.minion.Serviteur;

public abstract class Etat {
    protected Serviteur serviteur;

    public Etat(Serviteur serviteur) {
        this.serviteur = serviteur;
    }

    public void attaquer() {
    }

    public void dormir() {
    }

    public boolean peutAttaquer() {
        return false;
    }
}
