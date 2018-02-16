package hero;

import java.util.ArrayList;

import card.Card;
import card.CardList;
import card.effect.Armor;

public class Warrior extends Hero {

    /**
     * Constructeur de la classe Warrior
     * @param HP - Les points de vie
     * @param AP - Les points d'armure
     * @param MP - Les points de mana
     */
    public Warrior(int HP, int AP, int MP) {
        super(HP, AP, MP, new Armor());
    }

    /**
     * Méthode permettant de retourner la liste de carte spécifique au Hero Warrior.
     * @return CardList.warriorCards - La liste de cartes Warrior.
     */
    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.warriorCards;
    }

    @Override
    public String toString() {
        return "Guerrier " + super.toString();
    }

}
