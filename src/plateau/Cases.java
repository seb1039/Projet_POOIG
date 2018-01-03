package plateau;

import joueur.Pion;

public abstract class Cases {
	
	private Pion occupant;
	//private String question;

	
	
	//Accesseurs
	public void setOccupant(Pion occupant) {
		this.occupant = occupant;
	}
	
	public Pion getOccupant() {
		return occupant;
	}

	//Regarde si la case est occupée
	public boolean estOccupee(){
		return this.occupant!=null;
	}
	
	

	
	public abstract boolean estSpeciale();
	
	//Affichage
	public String toString(){
		return ((this.occupant == null) ? "  " : this.occupant.toString());
	}

	

	
	

}
