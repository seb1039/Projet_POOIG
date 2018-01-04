package jeu;

public class PartieOie1 extends PartieOie {
	//Arrêt du jeu si dépassement de 63
	
	
	@Override 
	public int finDuJeu(int posCour, int des) {
		return 63;
	}


}


