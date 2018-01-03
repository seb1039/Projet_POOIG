package joueur;

public class Pion {

	private int scorePion;
	private int numero;
	private int position;
	private boolean libre;
	private Joueur j;

	public Pion(int numero, Joueur joueur) {
		this.position = -1;
		this.numero = numero;
		this.libre = true;
		this.j = joueur;
	}


	public int getScorePion() {
		return scorePion;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean estLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Joueur getJ() {
		return j;
	}
	
	/**
	 * @param i
	 * 			Le taille pas du pion à affectuer
	 * @return La position finale du pion
	 */
	public int seDeplacer(int i) {
		return this.position += i;
	}

	public String toString(){
		return "" + this.j.toString() + "(" + this.numero + ")";
	}

}
