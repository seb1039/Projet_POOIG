package plateau;

public class CasesHotel extends CasesAttente {
	
	

	private int debut;
	private final int wait = 2;
	
	public int getDebut() {
		return debut;
	}
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
	 * @param tourActuel
	 * @return true si le joueur a suffisamment patienté
	 */
	public boolean libere(int tourActuel) {
		return tourActuel - debut >= wait;
	}
}
