package plateau;

public class Plateau {
	
	private final Cases[] plateau;
	
	//Constructeur
	public Plateau() {
		plateau = new Cases[64];
		for (int i = 0; i < 64; i++) {
			if ((i + 1) % 9 == 0 && i != 9) {
				plateau[i] = new CasesRejouer();
			} else if (i == 9){
				plateau[i] = new CasesNeuf();
			}
			else if (i == 6){
				plateau[i] = new CasesSaut(12);
			}
			else if (i == 19){
				plateau[i] = new CasesHotel();
			}
			else if (i == 31){
				plateau[i] = new CasesLiberation();
			}
			else if (i == 42){
				plateau[i] = new CasesSaut(30);
			}
			else if (i == 52){
				plateau[i] = new CasesLiberation();
			}
			else if (i == 58){
				plateau[i] = new CasesSaut(1);
			}
			else{
				plateau[i] = new CasesNormales();
			}
		}
	}
	
	public boolean estfini(){
		return plateau[63].estOccupee();
	}
	
	//Accesseur
	public Cases getCases(int i){
		return plateau[i];
	}
	

}
