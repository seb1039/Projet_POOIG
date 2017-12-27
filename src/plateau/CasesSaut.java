package plateau;
import jeu.*;

public class CasesSaut extends CasesSpeciales {
	
	private final int dest;
	
	public CasesSaut(int dest) {
		super();
		this.dest = dest;
	}
	
	public int getDest() {
		return this.dest;
	}
	
	public void deplacementSaut(int newPos, Joueur participant, Partie p) {
		int posCour = newPos;
		p.libereCase(posCour);
		p.occupeCase(this.dest, participant);
	}

}
