package jeu;

import java.util.Scanner;

import plateau.Plateau;


public abstract class Partie {

	protected Plateau p;
	
	/**
	 * @return true si la partie est finie <br/> false si la partie continue
	 * @see Plateau#estfini()
	 */
	public boolean estfinie() {
		return p.estfini();
	}

	
	/**
	 * Libère la case dont l'indice est en argument
	 * @param pos
	 * 			Indice de la case à libérer
	 * 
	 */
	public void libereCase(int pos) {
		if (pos != -1)
		p.getCases(pos).setOccupant(null);
	}
	
	public String toString() {
		return this.p.toString() + "\n";
	}
	
	/**
	 * Déplacement suivant positions/cases<br/>
	 * Gère le fonctionnement d'un tour du jeu<br/>
	 * Est redéfini dans les sous-classes
	 */
	public abstract void deroulement();
	public abstract Plateau getP();
	public abstract void initialisation(Scanner sc);
	public abstract void initialisation(String[] nomsDesJoueurs);
}
