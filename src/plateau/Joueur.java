package plateau;

import java.util.Random;

public class Joueur {
	
	// variante private int score;
	private final String nom;
	private int position;
	private boolean libre;
	
	
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
	
	public boolean estLibre() {
		return libre;
	}


	public void setLibre(boolean libre) {
		this.libre = libre;
	}


	public int joueTour(De d1, De d2){
		int i = lanceDe(d1);
		i += lanceDe(d2);
		return seDeplacer(i);
	}
	
	private int lanceDe(De d){
		d.nouveauLancer();
		return d.getDe();
	}
	
	private int seDeplacer(int i){
		return this.position += i;
	}
	
	

}
