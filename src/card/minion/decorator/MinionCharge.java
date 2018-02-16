package card.minion.decorator;

import card.minion.Minion;

public class MinionCharge extends Minion {
    Minion minion;

    /**
     * Constructeur de la classe MinionCharge
     * @param minion le minion à décorer
     */
    public MinionCharge(Minion minion) {
        super(minion);
        this.minion = minion;
        charge();
    }

    /**
     * Méthode qui permet d'implémenter l'effet de charge
     * @return True car le serviteur possède l'effet charge
     */
    @Override
    public boolean charge() {
        this.minion.toStateReady();
        return true;
    }

}
