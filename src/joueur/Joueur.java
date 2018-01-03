package joueur;

import java.util.Random;

import plateau.De;

public abstract class Joueur {
	
	// variante private int score;
	private final String nom;
	protected Pion[] mesPions;	
	
	//Constructeur
	public Joueur(String nom) {
		this.nom = nom;
	}

	//Accesseurs
	public String getNom() {
		return nom;
	}

	
	
	public Pion[] getMesPions() {
		return mesPions;
	}

	protected int lanceDe(De d){
		d.nouveauLancer();
		return d.getDe();
	}
	
	
	
	public String toString(){
		return this.nom;
	}
	
	

}
