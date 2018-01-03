package plateau;

import jeu.*;
import joueur.Joueur;
import joueur.Pion;

public class CasesLiberation extends CasesAttente {
	
	
	public void gestionLiberation(int pos, Pion j, PartieOie partieOie) {
		Pion j1 = ((CasesLiberation) partieOie.getP().getCases(pos)).getOccupant();
		if ((j1 !=null)){
			try{
				if (!j1.equals(j)){
					j1.setLibre(true);
					partieOie.setOccupantCases(pos+1, j1);
					j1.seDeplacer(1);
					}
			} catch (NullPointerException np) {
				System.out.println("Null Pointer Exception");
			}
		}
		j.setLibre(false);
		(partieOie.getP().getCases(pos)).setOccupant(j);
		j.seDeplacer(0);
	}

}
