package jeu;

public class PartieOie2 extends PartieOie {
	//Arrêt du jeu si un joueur sur la case 63 exactement

	@Override
	public int finDuJeu(int posCour, int des) {
		return 63-((posCour+des)-63);
		
	}
	
}
