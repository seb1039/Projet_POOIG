package plateau;

import joueur.Pion;

public class Cases {
	
	private Pion occupant;
	private final int scoreCase;
	//private String question;

	public Cases(int scoreCase) {
		this.scoreCase = scoreCase;
	}
	
	//Accesseurs
	public void setOccupant(Pion occupant) {
		this.occupant = occupant;
	}
	
	public Pion getOccupant() {
		return occupant;
	}
	
	public int getScoreCase() {
		return scoreCase;
	}

	//Regarde si la case est occupée
	public boolean estOccupee(){
		return this.occupant!=null;
	}
	
	

	
	/**
	 * @return true si la case est spéciale
	 */
	public boolean estSpeciale() {
		return false;
	}
	
	//Affichage
	public String toString(){
		return ((this.occupant == null) ? "  " : this.occupant.toString());
	}

	

	
	

}
