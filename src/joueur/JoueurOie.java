package joueur;

import jeu.PartieOie;
import plateau.De;
import plateau.Plateau;

public class JoueurOie extends Joueur {

	public JoueurOie(String nom, Plateau p) {
		super(nom,p);
		super.mesPions = new Pion[1];
		mesPions[0] = new Pion(1,this,p);
	}

	/**
	 * @param d1
	 *            Le dé n°1 de la partie du jeu de l'Oie
	 * @param d2
	 *            Le dé n°2 de la partie du jeu de l'Oie
	 * @return La position du pion après les lancers de dés
	 * @see Joueur#lanceDe(De)
	 */
	public int joueTour(De d1, De d2, PartieOie P) {
		Pion pion = mesPions[0];
		int i = lanceDe(d1);
		int posCour =pion.getPosition();
		int newPos = pion.seDeplacer(i);
		i += lanceDe(d2);
		if (pion.getPosition() > p.getTaille()) {
			// System.out.println("Fin du Game");
			newPos = P.finDuJeu(pion.getPosition(), P.getDe1().getDe() + P.getDe2().getDe());
			pion.setPosition(newPos);
		}
		return newPos;
	}

}
