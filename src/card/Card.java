package card;

public interface Card {

    /**
     * Méthode qui permet de renvoyer un booléen si la méthode est un sort
     * @return Boolean - True si la carte est un sort, false sinon
     */
    boolean isSpell();

    /**
     * Méthode qui permet de renvoyer un booléen si la méthode est un serviteur
     * @return Boolean - True si la carte est un serviteur, false sinon
     */
    boolean isMinion();

    /**
     * Méthode qui permet de renvoyer un entier, le coût en mana de la carte
     * @return int - Le coût en mana de la carte
     */
    int getMP();

}


