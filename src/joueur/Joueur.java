package joueur;

import plateau.De;
import plateau.Plateau;

public abstract class Joueur {

	// variante private int score;
	private final String nom;
	protected Pion[] mesPions;
	protected Plateau p;

	// Constructeur
	public Joueur(String nom, Plateau p) {
		this.nom = nom;
		this.p = p;
	}

	// Accesseurs
	public String getNom() {
		return nom;
	}

	public Pion[] getMesPions() {
		return mesPions;
	}

	/**
	 * @param d
	 *            Le dé de la partie en cours
	 * @return la valeur du dé
	 */
	protected int lanceDe(De d) {
		d.nouveauLancer();
		return d.getDe();
	}

	public String toString() {
		return this.nom;
	}

}
