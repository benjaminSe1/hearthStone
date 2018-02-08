package app.board;

import app.heros.Heros;

public class Board {
	private Plateau plateau;
	private Heros heros;
	
	public Board() {
		this.plateau = new Plateau();
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Heros getHeros() {
		return heros;
	}

	public void setHeros(Heros heros) {
		this.heros = heros;
	}
	
	
}
