package jeu;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import joueur.JoueurNumeri;
import joueur.Pion;
import plateau.*;

/**
 * @author seb
 *
 */
public class PartieNumeri extends Partie {

	protected LinkedList<JoueurNumeri> participants;
	private De de;

	// Constructeur
	public PartieNumeri() {
		super();
		super.p = new PlateauNumeri();
		this.participants = new LinkedList<JoueurNumeri>();

	}

	// Accesseurs
	@Override
	public PlateauNumeri getP() {
		return (PlateauNumeri) p;
	}

	public LinkedList<JoueurNumeri> getParticipants() {
		return participants;
	}

	public De getDe() {
		return de;
	}

	// Ajouter des participants
	/**
	 * @param j
	 *            joueur souhaitant rejoindre la partie
	 * @return true si l'ajout a été effectué
	 */
	public boolean addParticipants(JoueurNumeri j) {
		return this.participants.add(j);
	}

	/**
	 * Initialise la partie de Numeri (A METTRE DANS LA CLASSE PARTIE? )
	 * 
	 * @param sc
	 *            Scanner du main (A L'HEURE ACTUELLE)
	 * 
	 */
	public void initialisation(Scanner sc) {
		boolean continuer;
		int max;
		do {
			System.out.println("Qui veut jouer?");
			this.addParticipants(new JoueurNumeri(sc.nextLine(), this.p));
			System.out.println("Quelqu'un d'autre?");
			String s = sc.nextLine();
			continuer = (s.equals("oui"));
		} while (continuer);
		do {
			System.out.println("Quelle est la valeur maximale (entre 6 et 15) du dé que vous désirez ?");
			max = sc.nextInt();
		} while (max > 15 || max < 6);
		this.de = new De(max);
	}

	public void initialisation(String[] nomsDesJoueurs) {
		boolean continuer;
		for (String tmp : nomsDesJoueurs)
			this.addParticipants(new JoueurNumeri(tmp, this.p));
		this.de = new De(15);
	}
	
	public void setValMaxDe(int valMax){
		this.de.setMax(valMax);
	}

	/**
	 * @param joueur
	 * @return tableau de String contenant la combinaison choisie
	 */
	public String[] jouer(JoueurNumeri joueur) {
		return joueur.joueTour(this.getDe());
	}

	public void deroulement() {
		ListIterator<JoueurNumeri> it = this.participants.listIterator();
		Cases tmp;
		Pion pionCour;
		do {
			int newPos, posCour;
			boolean flag = false;
			JoueurNumeri courant = it.next();
			String[] joue = this.jouer(courant);
			for (String i : joue) {
				if (Integer.parseInt(i) > 0) {
					pionCour = courant.getMesPions()[Integer.parseInt(i) - 1];
					posCour = pionCour.getPosition();
					if (posCour != -1) {
						this.libereCase(posCour);
						try {
							tmp = p.getCases(posCour + 1);
						} catch (ArrayIndexOutOfBoundsException e) {
							tmp = p.getCases(posCour);
							flag = true;
						}
					} else {
						tmp = p.getCases(0);
					}
					if (!flag && (posCour == -1 || (posCour != -1 && peutSeDeplacer(posCour))))
						do {
							newPos = pionCour.seDeplacer(1);
							if (newPos <= this.p.getTaille()) {
								tmp = this.getP().getCases(newPos);
							} else {
								break;
							}
						} while (tmp.estOccupee());
					tmp.setOccupant(pionCour);
				}
			}
		} while (it.hasNext() && !estfinie());
	}

	public String finPartie() {
		for (JoueurNumeri j : this.participants) {
			j.calculScore();
		}
		return afficheClassement();
	}

	private String afficheClassement() {
		String rep = "";
		SortedMap<Integer, String> classement = new TreeMap<>();
		for (JoueurNumeri j : this.participants)
			classement.put(j.getScore(), j.getNom());
		return classement.toString();
	}

	private boolean peutSeDeplacer(int position) {
		if (position == 39)
			return false;
		for (int i = position + 1; i < p.getTaille(); i++) {
			if (!p.getCases(i).estOccupee())
				return true;

		}
		return false;
	}
}
