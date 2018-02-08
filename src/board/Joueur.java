package board;

import hero.Hero;

public class Joueur {
	private int numero;
	private String pseudo;
    private Hero hero;

    public Joueur(int numero, String pseudo, Hero hero) {
        super();
		this.numero = numero;
		this.pseudo = pseudo;
        this.hero = hero;
    }

	public int getNumero() {
		return numero;
	}

	public String getPseudo() {
		return pseudo;
	}
	
}
