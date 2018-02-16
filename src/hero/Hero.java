package hero;

import java.util.ArrayList;

import board.Player;
import card.Card;
import card.effect.EffectHero;
import hero.observer.Observer;
import hero.observer.ObserverHero;
import hero.observer.Sujet;
import util.MyLogger;

public abstract class Hero implements Sujet {

    protected int HP; //Points de vie

    protected int AP; // Point d'armure

    protected int MP; //Points de mana

    protected EffectHero effect;
    protected ArrayList<ObserverHero> observers;

    /**
     * Constructeur de la classe Hero
     * @param HP - Les points de vie du Hero
     * @param AP - Les points d'armure du Hero
     * @param MP - Les points de mana du Hero
     * @param effect - Le pouvoir Heroique du Hero
     */
    public Hero(int HP, int AP, int MP, EffectHero effect) {
        this.effect = effect;
        this.observers = new ArrayList<>();
        ObserverHero o = new ObserverHero(this);
        setData(HP, AP, MP);
    }

    public int getHP() {
        return HP;
    }

    public int getAP() {
        return AP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int pm) {
        this.MP = pm;
    }

    public EffectHero getEffect() {
        return effect;
    }

    /**
     * Méthode permettant d'utiliser le pouvoir héroique du Hero
     * @param p - Le joueur courant
     * @param pOpponent - Le joueur adverse
     */
    public void activateEffect(Player p, Player pOpponent) {
        this.effect.activateHeroEffect(p, pOpponent);
        removeMP(2);
    }

    public void incrementMP() {
        this.MP = this.MP + 1;
    }

    /**
     * Méthode permettant de mettre à jour la mana du Hero
     * @param mp
     */
    public void updateTurnMP(int mp) {
        this.setData(this.HP, this.AP, mp);
    }

    @Override
    public String toString() {
        return "[HP=" + HP + ", AP=" + AP + ", MP=" + MP + "]";
    }

    /**
     * Méthode permettant d'ajouter un observer
     * @param o - L'observer
     */
    public void attachObs(Observer o) {
        if (o instanceof ObserverHero) {
            observers.add((ObserverHero) o);
        } else {
            MyLogger.error("l'observeur n'a pas pu être ajouté");
        }
    }

    /**
     * Méthode permettant de retirer un observer
     * @param o - L'observer
     */
    @Override
    public void detachObs(Observer o) {
        if (o instanceof ObserverHero) {
            observers.remove((ObserverHero) o);
        } else {
            MyLogger.error("l'observeur n'a pas pu être supprimé");
        }
    }

    /**
     * Méthode permettant de notifier les observers
     */
    @Override
    public void notifyObs() {
        for (ObserverHero o : this.observers) {
            o.update(HP, AP, MP);
        }
    }

    /**
     * Méthode permettant de mettre à jour les données du Hero
     * @param HP - Les points de vie du Hero
     * @param AP - Les points d'armure du Hero
     * @param MP - Les points de mana du Hero
     */
    public void setData(int HP, int AP, int MP) {
        this.HP = HP;
        this.AP = AP;
        this.MP = MP;
        this.notifyObs();
    }

    /**
     * Méthode permettant de retirer des points de vie au Hero
     * @param HP - Le nombre de point de vie
     */
    public void removeHP(int HP) {
        if (this.AP > 0) {
            //Si le héro a des points d'armure, on va les lui enlever AP < pv enlevé, la méthode va se charge de les enlever
            this.removeAP(HP);
        } else {
            this.setData(this.HP - HP, this.AP, this.MP);
        }
    }

    /**
     * Méthode permettant d'ajouter des points d'armure au Hero
     * @param AP - Les points d'armure
     */
    public void addAP(int AP) {
        setData(this.HP, this.AP + AP, this.MP);
    }

    /**
     * Méthode permettant de retirer des points d'armure au Hero
     * @param AP - Les points d'armure
     */
    public void removeAP(int AP) {
        if (this.AP < AP) {
            int res = AP - this.AP;
            setData(this.HP - res, 0, this.MP);
        } else {
            setData(this.HP, this.AP - AP, this.MP);
        }
    }

    /**
     * Méthode permettant de retirer des points de mana au Hero
     * @param MP - Les points de mana
     */
    public void removeMP(int MP) {
        if (this.MP < MP) {
            this.setMP(0);
        } else {
            this.setMP(this.getMP() - MP);
        }
    }

    /**
     * Méthode réimplémentée permettant de récupérer la liste de cartes spécifique à la classe du Hero.
     * @return null
     */
    public ArrayList<Card> getHeroCards() {
        return null;
    }

}
