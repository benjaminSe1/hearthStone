package card.minion;

public class MinionSimple extends Minion {

    public MinionSimple(Minion s) {
        super(s);
    }

    /**
     * Constructeur de la classe MinionSimple
     * @param name le nom du serviteur
     * @param mp les points de mana pour instancier ce serviteur
     * @param dp les points de dégat du serviteur
     * @param hp les point de vie du serviteur
     */
    public MinionSimple(String name, int mp, int dp, int hp) {
        super(name, mp, dp, hp);
    }
}
