package joueur;

import plateau.Plateau;

public class Pion {

	private int scorePion;
	private int numero;
	private int position;
	private boolean libre;
	private Joueur j;
	private Plateau p;

	public Pion(int numero, Joueur joueur, Plateau plateau) {
		this.position = -1;
		this.numero = numero;
		this.libre = true;
		this.j = joueur;
		this.p=plateau;
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
	
	public int calculScore() {
		if(this.position != -1)
		this.scorePion = this.numero * this.p.getCases(this.position).getScoreCase();
		return this.scorePion;
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
