package card.effect;

import board.Player;

public interface EffectHero {

    /**
     * Méthode qui permet d'activer l'effet du pouvoir héroique d'un hero
     * @param p le hero qui active son pouvoir
     * @param pOpponent l'adversaire du héro p
     */
    void activateHeroEffect(Player p, Player pOpponent);
}
