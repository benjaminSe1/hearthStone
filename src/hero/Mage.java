package hero;

import java.util.ArrayList;

import card.Card;
import card.CardList;
import card.effect.FireBlast;

public class Mage extends Hero {

    /**
     * Constructeur de la classe Mage
     * @param HP - Les points de vie
     * @param AP - Les points d'armure
     * @param MP - Les points de mana
     */
    public Mage(int HP, int AP, int MP) {
        super(HP, AP, MP, new FireBlast());
    }

    /**
     * Méthode permettant de retourner la liste de carte spécifique au Hero Mage.
     * @return CardList.mageCards - La liste de cartes Mage.
     */
    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.mageCards;
    }

    @Override
    public String toString() {
        return "Mage " + super.toString();
    }
}
