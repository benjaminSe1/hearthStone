package app.board;

public class Joueur {
	private int numero;
	private String pseudo;
	private Board board;
	
	public Joueur(int numero, String pseudo) {
		super();
		this.numero = numero;
		this.pseudo = pseudo;
		this.board = new Board();
	}

	public int getNumero() {
		return numero;
	}

	public String getPseudo() {
		return pseudo;
	}
	
	public Board getBoard() {
		return board;
	}
	
}
