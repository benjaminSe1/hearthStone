package hero;

import java.util.ArrayList;

import card.Card;
import card.CardList;
import card.effect.Reinforce;

public class Paladin extends Hero {

    /**
     * Constructeur de la classe Paladin
     * @param HP - Les points de vie
     * @param AP - Les points d'armure
     * @param MP - Les points de mana
     */
    public Paladin(int HP, int AP, int MP) {
        super(HP, AP, MP, new Reinforce());
    }

    /**
     * Méthode permettant de retourner la liste de carte spécifique au Hero Paladin.
     * @return CardList.paladinCards - La liste de cartes Paladin.
     */
    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.paladinCards;
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}
