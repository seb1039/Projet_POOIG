package plateau;

import java.util.Random;

public class Des {
	
	private int de1;
	private int de2;
	
	public Des(){
		de1 = de2 = 0;
	}
	
	public int getDe1(){
		return this.de1;
	}
	
	public int getDe2(){
		return this.de2;
	}
	
	public void nouveauLancer(){
		Random n = new Random();
		de1 = 1 + n.nextInt(6);
		de2 = 1 + n.nextInt(6);
	}
	
	
}
