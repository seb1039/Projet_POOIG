package plateau;

public abstract class Cases {
	
	private Joueur occupant;
	
	
	//Constructeur
	public Cases(){};
	
	//Accesseurs
	public void setOccupant(Joueur occupant) {
		this.occupant = occupant;
	}
	
	public Joueur getOccupant() {
		return occupant;
	}

	//Regarde si la case est occupée
	public boolean estOccupee(){
		return this.occupant!=null;
	}

	
	public abstract boolean estSpeciale();

	

	
	

}
