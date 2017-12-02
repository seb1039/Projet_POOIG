package jeu;

import java.util.LinkedList;

import plateau.*;

public class Partie {

	private Plateau p;
	private LinkedList<Joueur> participants;
	private int tourActuel;
	private De de1;
	private De de2

	// Constructeur
	public Partie() {
		super();
		this.des = new Des();
		this.p = new Plateau();
		this.participants = new LinkedList<Joueur>();
		this.tourActuel = 0;
	}

	// Accesseurs
	public Plateau getP() {
		return p;
	}

	public Joueur getParticipant(int i) {
		return participants.get(i);
	}

	public LinkedList<Joueur> getParticipants() {
		return participants;
	}

	public int getTourActuel() {
		return tourActuel;
	}

	public Des getDes() {
		return this.des;
	}

	// Incrémentation du numéro du tour actuel
	public void incrementTour() {
		this.tourActuel++;
	}

	// Ajouter des participants
	public boolean addParticipants(Joueur j) {
		return this.participants.add(j);
	}

	public boolean estfinie() {
		return p.estfini();
	}

	public void libereCase(int pos) {
		p.getCases(pos).setOccupant(null);
	}

	public boolean occupeCase(int pos, Joueur j) {
		if (p.getCases(pos).estOccupee())
			return false;
		p.getCases(pos).setOccupant(j);
		return true;
	}

}
