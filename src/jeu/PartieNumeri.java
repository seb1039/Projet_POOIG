package jeu;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import joueur.JoueurNumeri;
import joueur.Pion;
import plateau.*;

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
	public boolean addParticipants(JoueurNumeri j) {
		return this.participants.add(j);
	}

	public void initialisation(Scanner sc) {
		boolean continuer;
		do {
			System.out.println("Qui veut jouer?");
			this.addParticipants(new JoueurNumeri(sc.nextLine()));
			System.out.println("Quelqu'un d'autre?");
			String s = sc.nextLine();
			continuer = (s.equals("oui"));
		} while (continuer);
		System.out.println("Quelle est la valeur maximale (entre 6 et 15) du dé que vous désirez ?");
		this.de = new De(sc.nextInt());
	}

	public String[] jouer(JoueurNumeri joueur) {
		return joueur.joueTour(this.getDe());
	}

	public void deroulement() {
		ListIterator<JoueurNumeri> it = this.participants.listIterator();
		Cases tmp;
		Pion pionCour;
		do {
			int newPos;
			JoueurNumeri courant = it.next();
			String[] joue = this.jouer(courant);
			for (String i : joue) {
				if (Integer.parseInt(i) > 0) {
					pionCour = courant.getMesPions()[Integer.parseInt(i) - 1];
					if (pionCour.getPosition() != -1) {
						this.libereCase(pionCour.getPosition());
						tmp = p.getCases(pionCour.getPosition() + 1);
					} else if (newPos == 1)
						this.libereCase(newPos - 1);
					else {
						tmp = p.getCases(0);
					}
					while (tmp.estOccupee()) {
						newPos = pionCour.seDeplacer(1);
						if (newPos <= this.p.getTaille()) {
							tmp = this.getP().getCases(newPos);
						}

						System.out.println("newPos : " + newPos);
					}
					tmp.setOccupant(pionCour);
				}
			}

		} while (it.hasNext());
	}

}
