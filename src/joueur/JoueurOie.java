package joueur;

import plateau.De;

public class JoueurOie extends Joueur {

	public JoueurOie(String nom) {
		super(nom);
		super.mesPions = new Pion[1];
		mesPions[0] = new Pion(1, this);
	}

	/**
	 * @param d1
	 *            Le dé n°1 de la partie du jeu de l'Oie
	 * @param d2
	 *            Le dé n°2 de la partie du jeu de l'Oie
	 * @return La position du pion après les lancers de dés
	 * @see Joueur#lanceDe(De)
	 */
	public int joueTour(De d1, De d2) {
		int i = lanceDe(d1);
		i += lanceDe(d2);
		return mesPions[0].seDeplacer(i);

	}

}
