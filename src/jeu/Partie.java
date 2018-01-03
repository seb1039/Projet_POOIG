package jeu;

import java.util.LinkedList;
import java.util.Scanner;

import joueur.Joueur;
import plateau.Plateau;


public abstract class Partie {

	protected Plateau p;
	
	public boolean estfinie() {
		return p.estfini();
	}

	public void libereCase(int pos) {
		p.getCases(pos).setOccupant(null);
	}
	
	public String toString() {
		return this.p.toString() + "\n";
	}
	
	public abstract void deroulement();
	public abstract Plateau getP();
}
