package card.effect;

import board.Player;

public interface Effect {

    /**
     * Méthode qui permet d'activer un effet
     * @param p Le joueur qui active l'effet
     * @param pOpponent l'adversaire du jouer p
     */
    void activateEffect(Player p, Player pOpponent);
}
