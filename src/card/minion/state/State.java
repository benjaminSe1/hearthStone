package card.minion.state;

import card.minion.Minion;

public abstract class State {
    protected Minion minion;

    public State(Minion minion) {
        this.minion = minion;
    }

    public void attaquer() {
    }

    public void dormir() {
    }

    public boolean peutAttaquer() {
        return false;
    }
}
