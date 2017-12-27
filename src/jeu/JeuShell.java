package jeu;

import java.util.*;

import plateau.*;

public class JeuShell {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Partie partie = new Partie();
		boolean continuer;
		// Initialisation
		do {
			System.out.println("Qui veut jouer?");
			partie.addParticipants(new Joueur(sc.nextLine()));
			System.out.println("Quelqu'un d'autre?");
			continuer = (sc.nextLine() == "oui") ? true : false;
		} while (continuer);
		// Déroulement des tours
		while (!partie.estfinie()) {
			ListIterator<Joueur> it = partie.getParticipants().listIterator();
			partie.incrementTour();
			do {
				int posCour, newPos;
				Joueur courant = it.next();
				// Si la position du joueur est la case hotel, alors courant.libre(cases.libere)
				if (courant.estLibre()) {
					posCour = courant.getPosition();
					partie.libereCase(posCour);
					newPos = courant.joueTour(partie.getDe1(), partie.getDe2());
					partie.occupeCase(newPos, courant);
					if (partie.getP().getCases(newPos) instanceof CasesSaut) {
						if ((partie.getP().getCases(newPos) instanceof CasesNeuf))
							((CasesNeuf)partie.getP().getCases(newPos)).deplacementSaut(newPos, courant, partie);
						} else
							((CasesSaut)partie.getP().getCases(newPos)).deplacementSaut(newPos, courant, partie);
					}
					else if (partie.getP().getCases(newPos) instanceof CasesAttente) {
						courant.setLibre(false);
						if (partie.getP().getCases(newPos) instanceof CasesHotel) {
							((CasesHotel)partie.getP().getCases(newPos)).setDebut(partie.getTourActuel());
						}
					}
				}
			} while (it.hasNext());
		}

	}

}
