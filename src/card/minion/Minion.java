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

    public Minion(String name, int MP, int DP, int HP) {
        this.MP = MP;
        this.name = name;
        //init du state
        this.stateReady = new StateReady(this);
        this.stateSleep = new StateDormir(this);
        this.stateCurrent = this.stateSleep;
        setData(HP, DP);
    }

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

    public int getDP() {
        return DP;
        }

    public int getMP() {
        return MP;
        }

    public String getName() {
        return name;
        }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDP(int DP) {
        this.DP = DP;
    }

    public boolean isAwaken() {
        return stateCurrent.canAttack();
    }

    public String toString() {
        return "Serviteur [" + name + " - " + MP + "/" + DP + "/" + HP + " - " + stateCurrent + "]";
        }

    public void removeHP(int HP) {
        setData(this.HP - HP, this.DP);
        }

    public void addHP(int HP) {
        setData(this.HP + HP, this.DP);
        }

    public void removeDP(int DP) {
        setData(this.HP, (this.DP - DP >= 0 ? this.DP - DP : 0));
        }

    public void addDP(int DP) {
        setData(this.HP, this.DP + DP);
        }

    //méthodes du state

    public void toStateReady() {
        stateCurrent = stateReady;
    }

    public void toStateSleep() {
        stateCurrent = stateSleep;
        }

    public void setData(int HP, int DP) {
        this.HP = HP;
        this.DP = DP;
    }

    public boolean charge() {
        return false;
    }

    public boolean stealLife() {
        return false;
    }

    public boolean enhance() {
        return false;
    }

    public boolean taunt() {
        return false;
    }

    public boolean isSpell() {
        return false;
    }

    public boolean isMinion() {
        return true;
    }
}
