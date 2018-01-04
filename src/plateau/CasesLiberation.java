package plateau;

import jeu.*;
import joueur.Pion;

public class CasesLiberation extends CasesAttente {

	/**
	 * 
	 * ATTENTION : NE FAUT-IL PAS REFAIRE CETTE MÉTHODE POUR LA RENDRE PLUS LISIBLE ?<br/>
	 * 
	 * Gestion de la libération<br/>
	 * Vérifie si la case n'est pas déjà occupée. Si elle l'est alors on libère
	 * l'ancien occupant et on le remplace par le nouveau. Sinon on met seulement le
	 * pion dans cette case
	 * 
	 * @param pos
	 *            La position de la CasesLiberation
	 * @param j
	 *            Le pion à capturer
	 * @param partieOie
	 *            La partie associé au plateau contenant la CasesLiberation
	 */
	public void gestionLiberation(int pos, Pion j, PartieOie partieOie) {
		Pion j1 = ((CasesLiberation) partieOie.getP().getCases(pos)).getOccupant();
		if ((j1 != null)) {
			try {
				if (!j1.equals(j)) {
					j1.setLibre(true);
					partieOie.setOccupantCases(pos + 1, j1);
					j1.seDeplacer(1);
				}
			} catch (NullPointerException np) {
				System.out.println("Null Pointer Exception");
			}
		}
		j.setLibre(false);
		(partieOie.getP().getCases(pos)).setOccupant(j);
		j.seDeplacer(0);
	}

}
