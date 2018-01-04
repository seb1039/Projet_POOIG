package plateau;

public class PlateauNumeri extends Plateau{
	
	//Constructeur
		public PlateauNumeri() {
			super(39);
			for (int i = 0; i < taille+1; i++) {
				if (i>=0 && i<=2) {
				plateau[i] = new Cases(-3);
				} else if (i==3 || i==4){
					plateau[i] = new Cases(-2);
				}
				else if (i==5 || i==6 ){
					plateau[i] = new Cases(-1);
				}
				else if (i == 9){
					plateau[i] = new Cases(1);
				}
				else if (i == 12){
					plateau[i] = new Cases(2);
				}
				else if (i == 14){
					plateau[i] = new Cases(3);
				}
				else if (i == 16){
					plateau[i] = new Cases(4);
				}
				else if (i == 18){
					plateau[i] = new Cases(5);
				}
				else if (i == 19){
					plateau[i] = new Cases(6);
				}
				else if (i == 22){
					plateau[i] = new Cases(7);
				}
				else if (i == 25){
					plateau[i] = new Cases(8);
				}
				else if (i == 27){
					plateau[i] = new Cases(9);
				}
				else if (i == 28){
					plateau[i] = new Cases(10);
				}
				else if (i == 30){
					plateau[i] = new Cases(11);
				}
				else if (i == 31){
					plateau[i] = new Cases(12);
				}
				else if (i == 33){
					plateau[i] = new Cases(13);
				}
				else if (i == 34){
					plateau[i] = new Cases(15);
				}
				else if (i == 36){
					plateau[i] = new Cases(20);
				}
				else if (i == 37){
					plateau[i] = new Cases(25);
				}
				else if (i == 39){
					plateau[i] = new Cases(30);
				}
				else{
					plateau[i] = new Cases(0);
				}
			}
		}

		/**
		 * @return true si les 3 dernières cases sont occupés
		 * @see plateau.Plateau#estfini()
		 */
		@Override
		public boolean estfini() {
			return plateau[this.taille].estOccupee() && plateau[this.taille-1].estOccupee() && plateau[this.taille-2].estOccupee();
		}

}
