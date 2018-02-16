package card;

public interface Card {

    /**
     * Méthode qui permet de renvoyer un booléen si la méthode est un sort
     */
    boolean isSpell();

    /**
     * Méthode qui permet de renvoyer un booléen si la méthode est un serviteur
     */
    boolean isMinion();

    /**
     * Méthode qui permet de renvoyer un entier, le coût en mana de la carte
     */
    int getMP();

}


