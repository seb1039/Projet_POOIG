package plateau;

public class CasesScore extends Cases{
	
	private int scoreCase;
	
	

	public CasesScore(int scoreCase) {
		super();
		this.scoreCase = scoreCase;
	}



	@Override
	public boolean estSpeciale() {
		return false;
	}

}
