package card.effect;

import board.Player;
import util.MyLogger;
import util.CardList;

public class Reinforce implements EffectHero {

    @Override
    public void activerEffetHeros(Player j, Player jAdversaire) {
        //Ajoute sur le board allié la card renfort
        j.getBoard().ajouterCarte(CardList.silverHandRecruit);
        MyLogger.game("Un " + CardList.silverHandRecruit.toString() + "est apparu sur le terrain allié !");
    }

    @Override
    public String toString() {
        return "Reinforce";
    }

}
