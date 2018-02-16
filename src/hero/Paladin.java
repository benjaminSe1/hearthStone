package hero;

import card.Card;
import card.CardList;
import card.effect.Reinforce;

import java.util.ArrayList;

public class Paladin extends Hero {

    public Paladin(int HP, int AP, int MP) {
        super(HP, AP, MP, new Reinforce());
    }

    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.paladinCards;
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}
