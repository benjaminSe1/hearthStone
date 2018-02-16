package hero;

import java.util.ArrayList;

import card.Card;
import card.effect.Reinforce;
import util.CardList;

public class Paladin extends Hero {

    public Paladin(int HP, int AP, int MP) {
        super(HP, AP, MP, new Reinforce());
    }

    @Override
    public ArrayList<Card> getHeroCards() {
        return CardList.cartesPaladin;
    }

    @Override
    public String toString() {
        return "Paladin " + super.toString();
    }
}
