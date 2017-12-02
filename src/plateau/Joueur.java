package plateau;

import java.util.Random;

public class Joueur {
	
	// variante private int score;
	private final String nom;
	private int position;
	
	
	//Construteur
	public Joueur(String nom) {
		this.nom = nom;
		this.position = 0;
	}


	//Accesseurs
	public String getNom() {
		return nom;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public int joueTour(Des d){
		int i = lanceDes(d);
		return seDeplacer(i);
	}
	
	private int lanceDes(Des d){
		d.nouveauLancer();
		return d.getDe1() + d.getDe2();
	}
	
	private int seDeplacer(int i){
		return this.position += i;
	}
	
	

}
