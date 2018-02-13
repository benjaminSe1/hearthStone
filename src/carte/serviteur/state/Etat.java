package carte.serviteur.state;

import carte.serviteur.ServiteurSimple;

public abstract class Etat {
    protected ServiteurSimple serviteur;

    public Etat(ServiteurSimple serviteur) {
        this.serviteur = serviteur;
    }

    public void attaquer() {
    }

    ;

    public void dormir() {
    }

    ;

    public boolean peutAttaquer() {
        return false;
    }

    ;
}
