package interfaceGraphique;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPlateauOie extends JPanel {
	
	private JCases[] plateau;
	private Modele modele;

	public JPlateauOie(Modele modele) {
		super();
		this.modele = modele;
		GridLayout gl = new GridLayout(8, 8);

		setLayout(gl);

		plateau = new JCases[64];
		for (int i = 0; i < 64; i++){
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
		for(int i = 0; i <64; i++)
			plateau[i].majCases();
	}
	

}
