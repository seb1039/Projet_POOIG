package plateau;

public class PlateauOie extends Plateau {

	// Constructeur
	public PlateauOie() {
		super(64);
		for (int i = 0; i < taille + 1; i++) {
			if ((i) % 9 == 0 && i != 9) {
				plateau[i] = new CasesRejouer();
			} else if (i == 9) {
				plateau[i] = new CasesNeuf();
			} else if (i == 6) {
				plateau[i] = new CasesSaut(12);
			} else if (i == 19) {
				plateau[i] = new CasesHotel();
			} else if (i == 31) {
				plateau[i] = new CasesLiberation();
			} else if (i == 42) {
				plateau[i] = new CasesSaut(30);
			} else if (i == 52) {
				plateau[i] = new CasesLiberation();
			} else if (i == 58) {
				plateau[i] = new CasesSaut(1);
			} else {
				plateau[i] = new CasesNormales();
			}
		}
	}

	/**
	 * @return true si la dernière case est occupée
	 * @see plateau.Plateau#estfini()
	 */
	@Override
	public boolean estfini() {
		return plateau[this.taille].estOccupee();
	}

}
