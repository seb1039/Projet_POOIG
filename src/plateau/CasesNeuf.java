package plateau;

import jeu.Partie;

public class CasesNeuf extends CasesSaut {

	private final int destpremtour;

	public CasesNeuf() {
		super(53);
		this.destpremtour = 26;
	}

	public int getDestpremtour() {
		return this.destpremtour;
	}

	public void deplacementSaut(int newPos, Joueur participant, Partie p) {
		if (p.getTourActuel() == 1) {
			int posCour = newPos;
			p.libereCase(posCour);
			if (p.getDe1().getDe() == 3 || p.getDe2().getDe() == 3) {
				p.occupeCase(super.getDest(), participant);
			} else {
				p.occupeCase(destpremtour, participant);
			}
		}
	}
}
