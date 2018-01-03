package plateau;

public abstract class Plateau {
	
	protected final Cases[] plateau;
	protected final int taille;
	
	
	public Plateau(int taille) {
		this.taille = taille;
		this.plateau = new Cases[taille+1];
	}
	
	public abstract boolean estfini();
	
	//Accesseur
	public Cases getCases(int i){
		return plateau[i];
	}
	
	public int getTaille(){
		return this.taille;
	}
	
	public String toString(){
		String s="";
		for(int i=0; i<taille+1; i++){
			s+="[ " +i +" " +this.plateau[i].toString() +" ]";
		}
		return s;
	}

}
