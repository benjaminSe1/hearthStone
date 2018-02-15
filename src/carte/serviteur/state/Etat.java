package carte.serviteur.state;

import carte.serviteur.Serviteur;

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
