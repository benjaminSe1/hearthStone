package hero;

import java.util.ArrayList;

import board.Player;
import card.Card;
import card.effect.EffetHeros;
import util.MyLogger;
import hero.observer.ObserverHero;
import hero.observer.Observer;
import hero.observer.Sujet;

public abstract class Hero implements Sujet {
    protected int PV; //Points de vie
    protected int PA; // Point d'armure
    protected int PM; //Points de mana
    protected EffetHeros effet;
    protected ArrayList<ObserverHero> observers;

    public Hero(int PV, int PA, int PM, EffetHeros effet) {
        this.effet = effet;
        this.observers = new ArrayList<>();
        ObserverHero o = new ObserverHero(this);
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

    public void setPM(int pm) {
        this.PM = pm;
    }

    public EffetHeros getEffet() {
        return effet;
    }

    public void activerEffet(Player j, Player jAdverse) {
        this.effet.activerEffetHeros(j, jAdverse);
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

    public void enregistrerObs(Observer o) {
        if(o instanceof ObserverHero){
            observers.add((ObserverHero) o);
        } else {
            MyLogger.error("l'observeur n'a pas pu être ajouté");
        }
    }

    @Override
    public void supprimerObs(Observer o) {
        if(o instanceof ObserverHero){
            observers.remove((ObserverHero) o);
        } else {
            MyLogger.error("l'observeur n'a pas pu être supprimé");
        }
    }

    @Override
    public void notifierObs() {
        for(ObserverHero o : this.observers){
            o.actualiser(PV, PA, PM);
        }
    }

    public void setDonnees(int PV, int PA, int PM) {
        this.PV = PV;
        this.PA = PA;
        this.PM = PM;

        this.notifierObs();
    }

    public void supprimerPV(int PV) {
        if (this.PA > 0) {
            //Si le héro a des points d'armure, on va les lui enlever PA < pv enlevé, la méthode va se charger de les enlever
            this.supprimerPA(PV);
        } else {
            this.setDonnees(this.PV - PV, this.PA, this.PM);
        }
    }

    public void ajouterPA(int PA) {
        setDonnees(this.PV, this.PA + PA, this.PM);
    }

    public void supprimerPA(int PA) {
        if (this.PA < PA) {
            int reste = PA - this.PA;
            setDonnees(this.PV - reste, 0, this.PM);
        } else {
            setDonnees(this.PV, this.PA - PA, this.PM);
        }
    }

    public void supprimerPM(int PM) {
        if (this.PM < PM) {
            this.setPM(0);
        } else {
            this.setPM(this.getPM() - PM);
        }
    }

    public ArrayList<Card> getCartesHeros() {
        return null;
    }

}
