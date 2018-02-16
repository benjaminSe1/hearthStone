package card.minion.state;

import card.minion.Minion;

public abstract class State {
    protected Minion minion;

    /**
     * Constructeur De la classe State
     * @param minion Le serviteur
     */
    public State(Minion minion) {
        this.minion = minion;
    }

    /**
     * Méthode qui permet de savoir si un serviteur peut attaquer
     * @return True si le serviteur peut attaquer, False sinon
     */
    public boolean canAttack() {
        return false;
    }
}
