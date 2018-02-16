package card.minion;

import card.Card;
import card.minion.state.State;
import card.minion.state.StateDormir;
import card.minion.state.StateReady;

public abstract class Minion implements Card {
    private int MP;
    private String name;
    private int HP;
    private int DP;
    private State stateSleep;
    private State stateReady;
    private State stateCurrent = stateSleep;

    /**
     * Constructeur de la classe Minion
     * @param name le nom du serviteur
     * @param MP les points de mana pour instancier ce serviteur
     * @param DP les points de dégat du serviteur
     * @param HP les point de vie du serviteur
     */
    public Minion(String name, int MP, int DP, int HP) {
        this.MP = MP;
        this.name = name;
        //init du state
        this.stateReady = new StateReady(this);
        this.stateSleep = new StateDormir(this);
        this.stateCurrent = this.stateSleep;
        setData(HP, DP);
    }

    /**
     * Constructeur de la classe Minion
     * @param minion le minion servant à créer la copie
     */
    public Minion(Minion minion) {
        this.MP = minion.getMP();
        this.name = minion.getName();
        //init du state
        this.stateReady = new StateReady(this);
        this.stateSleep = new StateDormir(this);
        this.stateCurrent = this.stateSleep;
        setData(minion.getHP(), minion.getDP());
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDP() {
        return DP;
    }

    public int getMP() {
        return MP;
    }

    public String getName() {
        return name;
    }

    /**
     * Méthode qui permet de savoir si le serviteur peut attaquer
     * @return True si le serviteur peut attaquer, False sinon
     */
    public boolean isAwaken() {
        return stateCurrent.canAttack();
    }

    public String toString() {
        return "Serviteur [" + name + " - " + MP + "/" + DP + "/" + HP + " - " + stateCurrent + "]";
    }

    /**
     * Méthode qui permet d'enlever des hp au serviteur
     * @param HP les hp a enlever
     */
    public void removeHP(int HP) {
        setData(this.HP - HP, this.DP);
    }

    public void addHP(int HP) {
        setData(this.HP + HP, this.DP);
    }

    public void addDP(int DP) {
        setData(this.HP, this.DP + DP);
    }

    //méthodes du state

    /**
     * Méthode qui permet de changer l'etat d'un serviteur pour le passer en stateReady
     */
    public void toStateReady() {
        stateCurrent = stateReady;
    }

    /**
     * Méthode qui permet de changer l'etat d'un serviteur pour le passer en stateSleep
     */
    public void toStateSleep() {
        stateCurrent = stateSleep;
    }

    /**
     * Méthode qui permet de mettre à jour les données d'un serviteur
     * @param HP - Les nouveaux points de vie du serviteur
     * @param DP - Les nouveaux points de dégats du serviteur
     */
    public void setData(int HP, int DP) {
        this.HP = HP;
        this.DP = DP;
    }

    /**
     * Méthode à ré-implémenter par les décorateurs pour activer les effets des serviteurs
     * @return false de base, le serviteur basique n'a pas d'effet
     */
    public boolean charge() {
        return false;
    }

    /**
     * Méthode à ré-implémenter par les décorateurs pour activer les effets des serviteurs
     * @return false de base, le serviteur basique n'a pas d'effet
     */
    public boolean stealLife() {
        return false;
    }

    /**
     * Méthode à ré-implémenter par les décorateurs pour activer les effets des serviteurs
     * @return false de base, le serviteur basique n'a pas d'effet
     */
    public boolean enhance() {
        return false;
    }

    /**
     * Méthode à ré-implémenter par les décorateurs pour activer les effets des serviteurs
     * @return false de base, le serviteur basique n'a pas d'effet
     */
    public boolean taunt() {
        return false;
    }

    /**
     * Méthode à ré-implémenter par les décorateurs pour activer les effets des serviteurs
     * @return false de base, le serviteur basique n'a pas d'effet
     */
    public boolean isSpell() {
        return false;
    }

    /**
     * Méthode à ré-implémenter par les décorateurs pour activer les effets des serviteurs
     * @return false de base, le serviteur basique n'a pas d'effet
     */
    public boolean isMinion() {
        return true;
    }
}
