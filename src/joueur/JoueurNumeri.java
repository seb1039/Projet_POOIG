package joueur;

import java.util.LinkedList;
import java.util.Scanner;

import interfaceGraphique.PropositionsNumeri;
import plateau.De;
import plateau.Plateau;

public class JoueurNumeri extends Joueur {

	private Propositions propositions;
	private int score;

	public JoueurNumeri(String nom, Plateau plateau) {
		super(nom, plateau);
		this.score = 0;
		super.mesPions = new Pion[6];
		for (int i = 1; i <= 6; i++) {
			mesPions[i - 1] = new Pion(i, this, plateau);
		}
	}

	public int getScore() {
		return score;
	}

	/**
	 * Calcul du Score du Joueur courant score = sommes(pion.score)
	 */
	public int calculScore() {
		int score = 0;
		for (Pion p : mesPions) {
			score += p.calculScore();
		}
		this.score = score;
		return this.score;
	}

	/**
	 * @param d
	 *            Dé de la partie
	 * @return tableau de String contenant la combinaison choisie
	 */
	public String[] joueTour(De d) {
		int i = lanceDe(d);
		return this.gestionPropositions(i);
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
	//	PropositionsNumeri p = new PropositionsNumeri(this.getTableauPropopositions(i));
		this.afficherPropositions(i);
		String[] rep = new String[1];
		boolean flag;
		int indice = 0;
		do {
		
		indice = this.choixPropositions();
		//	indice = p.getChoix();
			try {
		/**		try {
					notify();
					rep = this.propositions.getProposition(indice - 1);
				} catch (IllegalMonitorStateException e) {
					rep = this.propositions.getProposition(indice - 1);
				}
		**/
				rep = this.propositions.getProposition(indice - 1);
				flag = false;
			} catch (PropositionIncorrecteException e) {
				flag = true;
			}
		} while (flag);
		return rep;
	}

	/**
	 * Demande au joueur la combinaison qu'il souhaite
	 * 
	 * @return l'indice de la combinaison choisie
	 * @see JoueurNumeri#gestionPropositions
	 */
	private Integer choixPropositions() {
		Scanner sc = new Scanner(System.in);
		boolean flag;
		String rep;
		Integer choix = 0;
		do {

			System.out.println(super.toString() + ", quelle combinaison voulez-vous déplacer ? ");
			rep = sc.next();
			try {
				choix = Integer.parseInt(rep);
				flag = false;
			} catch (NumberFormatException nb) {
				flag = true;
			}
		} while (flag);
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
		System.out.println(getTableauPropopositions(i));
	}
	
	public String getTableauPropopositions(int i) {
		this.propositions = new Propositions(i);
		return propositions.toString();
		
	}
	
	/**
	 * Ceci est la classe proposition qui gère les propositions de coups possibles
	 *
	 */

	private class Propositions {

		private LinkedList<String> propositions;

		public Propositions(int i) {
			propositions = new LinkedList<>();
			this.generationProposition(i);
		}

		/**
		 * Génère toutes les combinaisons possibles. <br/>
		 * On limite le nombre de pions déplaçables simultanément à 3
		 * 
		 * @param i
		 *            la taille du dé utilisé
		 */
		private void generationProposition(int i) {
			if (i < 6) {
				for (int j = 0; j <= i  + 1; j++) {
					if ((i - j) > j)
						propositions.add("" + (i - j) + " " + j + " 0");
				}
			} else if (i >= 6)
				for (int j = 0; j < 7; j++) {
					for (int k = 0; k < 7; k++) {
					//	if (j > k && k > i - (j + k) && i - (j + k) < 7 && i - (j + k) >= 0) {
						if (  i - (j + k) < 7 && i - (j + k) > 0 &&
								 j < 7 && j > 0 &&
								k < 7 &&  k > 0) {
							propositions.add("" + j + " " + k + " " + (i - (j + k)));
						}
					}
				}
		}

		private String[] getProposition(int i) throws PropositionIncorrecteException {
			if (i < 0 || i >= propositions.size())
				throw new PropositionIncorrecteException();
			else
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
