package plateau;
import jeu.*;
import joueur.Joueur;
import joueur.Pion;

public class CasesSaut extends CasesSpeciales {
	
	private final int dest;
	
	public CasesSaut(int dest) {
		super();
		this.dest = dest;
	}
	
	public int getDest() {
		return this.dest;
	}
	
	public void deplacementSaut(int newPos, Pion participant, PartieOie partieOie) {
		int posCour = newPos;
		partieOie.libereCase(posCour);
		partieOie.setOccupantCases(this.dest, participant);
		participant.setPosition(this.dest);
	}

}
