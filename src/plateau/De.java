package plateau;

import java.util.Random;

public class De {
	
	private int de;
	private int max;
	private Random n;
	
	public De(int max){
		de = 0;
		this.max = max;
		n = new Random();
	}
	
	public int getDe(){
		return this.de;
	}
	
	public void setMax(int max){
		this.max = max;
	}
	
	/**
	 * Génère un nouveau nombre aléatoire entre 1 et max
	 * @see Random#nextInt(int)
	 */
	public void nouveauLancer(){
		de = 1 + n.nextInt(max);
	}
	
	
	
}
