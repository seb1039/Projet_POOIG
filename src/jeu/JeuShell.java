package jeu;

import java.util.*;

import plateau.Joueur;

public class JeuShell {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Partie partie = new Partie();
		boolean continuer;
		//Initialisation
		do{
			System.out.println("Qui veut jouer?");
			partie.addParticipants(new Joueur(sc.nextLine()));
			System.out.println("Quelqu'un d'autre?");
			continuer = (sc.nextLine() == "oui") ? true : false;
		}while(continuer);
		//Déroulement des tours
		while(!partie.estfinie()){
			ListIterator<Joueur> it = partie.getParticipants().listIterator();
			partie.incrementTour();
			do{
				int posCour, newPos;
				Joueur courant = it.next();
				posCour = courant.getPosition();
				partie.libereCase(posCour);				
				newPos = courant.joueTour(partie.getDe());
				partie.occupeCase(newPos,courant);
				if(newPos == 9 && partie.getTourActuel() == 1){
					if(partie.getDes().getDe1() == 3 || partie.getDe().getDe() == 3 ){
						//appel methodes de CasesNeuf
					}
						
				}
			}while(it.hasNext());
		}
		
	}

}
