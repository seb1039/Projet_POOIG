package interfaceGraphique;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPlateauNumeri extends JPlateau {
	
	private JCases[] plateau;
	private Modele modele;

	public JPlateauNumeri(Modele modele) {
		super();
		this.modele = modele;
		GridLayout gl = new GridLayout(8, 8);

		setLayout(gl);

		plateau = new JCases[40];
		for (int i = 0; i < 40; i++){
			plateau[i] = new JCases(i,this.modele);
			add(plateau[i]);
		}

		setSize(new Dimension(200, 200));
		setMaximumSize(new Dimension(650, 650));
	}
	
	public JCases getCases(int i){
		return plateau[i];
	}
	
	public void majPlateau(){
		for(int i = 0; i <40; i++)
			plateau[i].majCases();
	}
	

}
