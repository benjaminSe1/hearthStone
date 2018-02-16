package card.minion.state;

import card.minion.Minion;

public abstract class State {
    protected Minion minion;

    public State(Minion minion) {
        this.minion = minion;
    }

    public void attack() {
    }

    public void sleep() {
    }

    public boolean canAttack() {
        return false;
    }
}
