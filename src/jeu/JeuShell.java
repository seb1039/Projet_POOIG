package jeu;

import java.util.*;

import plateau.*;

public class JeuShell {

	public static void main(String[] args) {

		/**
		Scanner sc = new Scanner(System.in);
		PartieOie1 partie = new PartieOie1(); // Initialisation
		partie.initialisation(sc);
		// Déroulement des tours
		while (!partie.estfinie()) {
			partie.deroulement();
		}
		System.out.println(partie.toString());
		**/
		
		Scanner sc = new Scanner(System.in);
		PartieNumeri partie = new PartieNumeri(); // Initialisation
		partie.initialisation(sc);
		// Déroulement des tours
		while (!partie.estfinie()) {
			partie.deroulement();
			System.out.println(partie.toString());
		}
		System.out.println(partie.toString());
		

	}
}
