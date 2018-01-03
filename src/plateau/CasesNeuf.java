package plateau;

import jeu.PartieOie;
import jeu.PartieOie1;
import joueur.Joueur;
import joueur.Pion;

public class CasesNeuf extends CasesSaut {

	private final int destpremtour;

	public CasesNeuf() {
		super(53);
		this.destpremtour = 26;
	}

	public int getDestpremtour() {
		return this.destpremtour;
	}

	public void deplacementSaut(int newPos, Pion participant, PartieOie partieOie) {
		if (partieOie.getTourActuel() == 1) {
			int posCour = newPos;
			partieOie.libereCase(posCour);
			if (partieOie.getDe1().getDe() == 3 || partieOie.getDe2().getDe() == 3) {
				partieOie.setOccupantCases(super.getDest(), participant);
				participant.setPosition(super.getDest());
			} else {
				partieOie.setOccupantCases(destpremtour, participant);
				participant.setPosition(destpremtour);
			}
		}
	}
}
