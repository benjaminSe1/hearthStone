package hero;

import board.Board;
import carte.Carte;
import effect.EffetHeros;
import main.Log;
import observer.IObserverHero;
import observer.Observer;
import observer.Sujet;

import java.util.ArrayList;

public abstract class Hero implements Sujet {
    protected int PV; //Points de vie
    protected int PA; // Point d'armure
    protected int PM; //Points de mana
    protected EffetHeros effet;
    protected ArrayList<IObserverHero> observers;

    public Hero(int PV, int PA, int PM, EffetHeros effet) {
        this.effet = effet;
        this.observers = new ArrayList<>();
        setDonnees(PV, PA, PM);
    }

    public int getPV() {
        return PV;
    }

    public int getPA() {
        return PA;
    }

    public int getPM() {
        return PM;
    }

    public EffetHeros getEffet() {
        return effet;
    }

    public void activerEffet(Board board, Board boardAdverse) {
        this.effet.activerEffetHeros(board, boardAdverse, this);
        supprimerPM(2);
    }

    public void incrementerMana() {
        this.PM = this.PM + 1;
    }

    public void majTourPM(int pm) {
        this.setDonnees(this.PV, this.PA, pm);
    }

    @Override
    public String toString() {
        return "[PV=" + PV + ", PA=" + PA + ", PM=" + PM + "]";
    }

    //Methodes de l'observer Hero
    @Override
    public void enregistrerObs(Observer o) {
        if (o instanceof IObserverHero) {
            observers.add((IObserverHero) o);
        } else {
            Log.error("l'observeur n'a pas pu être ajouté");
        }
    }

    @Override
    public void supprimerObs(Observer o) {
        if (o instanceof IObserverHero) {
            observers.remove((IObserverHero) o);
        } else {
            Log.error("l'observeur n'a pas pu être supprimé");
        }
    }

    @Override
    public void notifierObs() {
        for (IObserverHero o : this.observers) {
            o.actualiser(PV, PA, PM);
        }
    }

    public void setDonnees(int PV, int PA, int PM) {
        this.PV = PV;
        this.PA = PA;
        this.PM = PM;

        notifierObs();
    }

    public void supprimerPV(int PV) {
        if (this.PA > 0) {
            //Si le héros a des points d'armure, on va les lui enlever (la méthode va aussi se charger de retirer les PV restants)
            supprimerPA(PV);
        } else {
            setDonnees(this.PV - PV, this.PA, this.PM);
        }
    }

    public void ajouterPA(int PA) {
        setDonnees(this.PV, this.PA + PA, this.PM);
    }

    public void supprimerPA(int PA) {
        //Si on essaye d'enlever plus d'armure que le héros n'en a, on enlève aussi les points de vie.
        if (this.PA < PA) {
            int reste = PA - this.PA;
            setDonnees(this.PV - reste, 0, this.PM);
        } else {
            setDonnees(this.PV, this.PA - PA, this.PM);
        }
    }

    public void supprimerPM(int PM) {
        if (this.PM < PM) {
            setDonnees(this.PV, this.PA, 0);
        } else {
            setDonnees(this.PV, this.PA, this.PM - PM);
        }
    }

    public ArrayList<Carte> getCartesHeros() {
        return null;
    }

}
