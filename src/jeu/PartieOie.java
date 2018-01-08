package jeu;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import joueur.JoueurNumeri;
import joueur.JoueurOie;
import joueur.Pion;
import plateau.Cases;
import plateau.CasesAttente;
import plateau.CasesHotel;
import plateau.CasesLiberation;
import plateau.CasesNeuf;
import plateau.CasesRejouer;
import plateau.CasesSaut;
import plateau.De;
import plateau.PlateauOie;

public abstract class PartieOie extends Partie {

	protected LinkedList<JoueurOie> participants;
	private int tourActuel;
	private De de1;
	private De de2;

	// Constructeur
	public PartieOie() {
		super();
		this.de1 = new De(6);
		this.de2 = new De(6);
		super.p = new PlateauOie();
		this.participants = new LinkedList<JoueurOie>();
		this.tourActuel = 0;
	}

	// Accesseurs
	@Override
	public PlateauOie getP() {
		return (PlateauOie) p;
	}

	public JoueurOie getParticipant(int i) {
		return participants.get(i);
	}

	public LinkedList<JoueurOie> getParticipants() {
		return participants;
	}

	public int getTourActuel() {
		return tourActuel;
	}

	public De getDe1() {
		return this.de1;
	}

	public De getDe2() {
		return this.de2;
	}

	/**
	 * Incrémente le numéro du tour actuel
	 */
	public void incrementTour() {
		this.tourActuel++;
	}

	/**
	 * @param j
	 *            joueur souhaitant rejoindre la partie
	 * @return true si l'ajout a été effectué
	 */
	public boolean addParticipants(JoueurOie j) {
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
		do {
			System.out.println("Qui veut jouer?");
			this.addParticipants(new JoueurOie(sc.nextLine(), this.p));
			System.out.println("Quelqu'un d'autre?");
			String s = sc.nextLine();
			continuer = (s.equals("oui"));

		} while (continuer);
	}
	
	public void initialisation(String[] nomsDesJoueurs) {
		boolean continuer;
		for (String tmp : nomsDesJoueurs)
			this.addParticipants(new JoueurOie(tmp, this.p));
	}

	public void afficheGagnant(){
		System.out.println("" + p.getCases(63).getOccupant().getJ().toString() + " a gagné");
	}
	
	
	/**
	 * public int occupeCase(int pos, Joueur j) { Cases tmp =
	 * this.getP().getCases(pos); this.libereCase(j.getPosition()); if (pos >=
	 * p.getTaille()) { pos = finDuJeu(pos, this.getDe1().getDe() +
	 * this.getDe2().getDe()); } else { while (tmp.estOccupee()) { tmp =
	 * this.getP().getCases(pos); if (tmp instanceof CasesLiberation) {
	 * ((CasesLiberation) tmp).gestionLiberation(pos, j, this); } pos--; } } tmp =
	 * this.getP().getCases(pos); tmp.setOccupant(j); j.setPosition(pos); return
	 * pos;
	 * 
	 * }
	 * 
	 * // Jouer un tour = lancer dès + déplacement public int jouer(Joueur joueur)
	 * 
	 * { int posCour = joueur.getPosition(); this.libereCase(posCour); int newPos;
	 * newPos = joueur.joueTour(this.getDe1(), this.getDe2()); if (newPos >=
	 * p.getTaille()) { newPos = this.finDuJeu(posCour, de1.getDe() + de2.getDe());
	 * } newPos = this.occupeCase(newPos, joueur); joueur.setPosition(newPos);
	 * return newPos; }
	 **/
	/**
	 * @param i
	 *            indice de la case à occuper
	 * @param pion
	 *            pion à placer
	 */
	public void setOccupantCases(int i, Pion pion) {
		p.getCases(i).setOccupant(pion);
	}

	/**
	 * @param joueur
	 *            JoueurOie qui est en train de jouer
	 * @return nouvelle position du pion du joueur
	 */
	public int jouer(JoueurOie joueur) {
		Pion pion = joueur.getMesPions()[0];
		this.libereCase(pion.getPosition());
		int newPos = joueur.joueTour(this.getDe1(), this.getDe2(),this);
		Cases tmp;
		if (newPos > this.p.getTaille()) {
			newPos = this.finDuJeu(pion.getPosition(), this.getDe1().getDe() + this.getDe2().getDe());
			tmp = this.p.getCases(newPos);
			} else {
			tmp = this.p.getCases(newPos);
			while (tmp.estOccupee()) {
				if (tmp instanceof CasesLiberation) {
					((CasesLiberation) tmp).gestionLiberation(newPos, pion, this);
					
					return newPos;
				}
				newPos--;
				tmp = this.p.getCases(newPos);

			}
		}
		tmp.setOccupant(pion);
		return newPos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jeu.Partie#deroulement()
	 */
	@Override
	public void deroulement() throws PartieNullException{
		ListIterator<JoueurOie> it = this.getParticipants().listIterator();
		this.incrementTour();
		Cases tmp;
		do {
			int newPos;
			JoueurOie joueurCour = it.next();
			Pion pionCour = joueurCour.getMesPions()[0];
			// Si la position du joueur est la case hotel, alors
			// courant.libre(cases.libere)
			if (tousLesJoueursPieges()) {
				throw new PartieNullException();
			//	System.out.println("Tout le monde a perdu");
			//	continue;
			}
			if (!pionCour.estLibre())
				if (this.getP().getCases(pionCour.getPosition()) instanceof CasesHotel) {
					tmp = this.getP().getCases(pionCour.getPosition());
					pionCour.setLibre(((CasesHotel) tmp).libere(this.getTourActuel()));
				}
			if (pionCour.estLibre()) {
				do {
					newPos = this.jouer(joueurCour);
					tmp = this.getP().getCases(newPos);
				} while ( tmp instanceof CasesRejouer || (newPos == 9 && this.getTourActuel() != 1));
				if (tmp instanceof CasesSaut) {

					if (tmp instanceof CasesNeuf) {
						((CasesNeuf) tmp).deplacementSaut(newPos, pionCour, this);
					} else {
						((CasesSaut) tmp).deplacementSaut(newPos, pionCour, this);
					}
				} else if (tmp instanceof CasesAttente) {
					pionCour.setLibre(false);
					if (tmp instanceof CasesHotel) {
						((CasesHotel) tmp).setDebut(this.getTourActuel());
					}
				}

			}
		} while (it.hasNext());
		System.out.println("Tour n° " + this.getTourActuel() + " : ");
		System.out.println(this.toString());
	}

	public boolean tousLesJoueursPieges() {
		int i = 0;
		Cases tmp;
		for (JoueurOie j : this.participants) {
			if (j.getMesPions()[0].getPosition() != -1) {
				tmp = p.getCases(j.getMesPions()[0].getPosition());
				if (tmp instanceof CasesLiberation)
					i++;
			}
		}
		return (i == this.participants.size());
	}

	/**
	 * @param posCour
	 *            indice de la position courante
	 * @param des
	 *            valeur des dés de la partie
	 * @return la position retenue par le jeu selon la variante
	 */
	public abstract int finDuJeu(int posCour, int des);
}
