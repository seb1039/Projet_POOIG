package joueur;

import java.util.LinkedList;
import java.util.Scanner;

import plateau.De;

public class JoueurNumeri extends Joueur {

	private Propositions propositions;

	public JoueurNumeri(String nom) {
		super(nom);
		super.mesPions = new Pion[6];
		for (int i = 1; i <= 6; i++) {
			mesPions[i - 1] = new Pion(i, this);
		}
	}

	/**
	 * @param d
	 *            Dé de la partie
	 * @return tableau de String contenant la combinaison choisie
	 */
	public String[] joueTour(De d) {
		int i = lanceDe(d);
		return this.gestionPropositions(i);
		// String[] pionsADeplacer = this.gestionPropositions(i);
		// this.seDeplacer(pionsADeplacer);
	}

	/**
	 * Déplace chaque pion dont les indices sont dans le tableau
	 * 
	 * @param pionsADeplacer
	 *            tableau de String contenant la combinaison choisie
	 */
	public void seDeplacer(String[] pionsADeplacer) {
		for (String s : pionsADeplacer) {
			int ind = Integer.parseInt(s);
			mesPions[ind].seDeplacer(1);
		}
	}

	/**
	 * Affiche les propositions de coups possibles <br/>
	 * Demande au joueur de choisir la proposition acceptée
	 * 
	 * @param i
	 *            indice de la proposition choisie par le joueur
	 * @return tableau de String contenant la combinaison choisie
	 * @see JoueurNumeri#choixPropositions
	 * @see JoueurNumeri#afficherPropositions(int)
	 */
	public String[] gestionPropositions(int i) {
		this.afficherPropositions(i);
		int indice = this.choixPropositions();
		return this.propositions.getProposition(indice - 1);
	}

	/**
	 * Demande au joueur la combinaison qu'il souhaite
	 * 
	 * @return l'indice de la combinaison choisie
	 * @see JoueurNumeri#gestionPropositions
	 */
	private int choixPropositions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle combinaison voulez-vous déplacer ? ");
		int choix = sc.nextInt();
		return choix;
	}

	/**
	 * Affiche les différentes propositions de coups possibles
	 * 
	 * @param i
	 *            la taille du dé utilisé
	 * @see JoueurNumeri#gestionPropositions
	 */
	public void afficherPropositions(int i) {
		this.propositions = new Propositions(i);
		System.out.println(propositions.toString());
	}

	private class Propositions {

		private LinkedList<String> propositions;

		public Propositions(int i) {
			propositions = new LinkedList<>();
			this.generationProposition(i);
		}

		/**
		 * Génère toutes les combinaisons possibles. <br/>
		 * On limite le nombre de pions déplaçables simultanément à 3
		 * @param i
		 *            la taille du dé utilisé
		 */
		private void generationProposition(int i) {
			if (i < 6) {
				for (int j = 0; j <= i / 2 + 1; j++) {
					if ((i - j) > j)
						propositions.add("" + (i - j) + " " + j + " 0");
				}
			} else if (i >= 6)
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 7; k++) {
						if (j > k && k > i - (j + k) && i - (j + k) < 7 && i - (j + k) >= 0) {
							propositions.add("" + j + " " + k + " " + (i - (j + k)));
						}
					}
				}
		}

		private String[] getProposition(int i) {
			return propositions.get(i).split(" ");
		}

		public String toString() {
			String rep = "";
			for (int i = 0; i < propositions.size(); i++)
				rep += (i + 1) + ")" + propositions.get(i) + "\n";
			return rep;
		}

	}

}
