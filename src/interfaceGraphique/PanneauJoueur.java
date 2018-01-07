package interfaceGraphique;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanneauJoueur extends JPanel {
	
	private JTextField nom;
	private int numero;
	
	public PanneauJoueur(int numero){
		super();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); 
		this.numero = numero;
		
		JTextArea joueur = new JTextArea("Joueur n° " + this.numero);
		joueur.setEditable(false);
		
		nom = new JTextField();
		
		add(joueur);
		add(nom);
	}
	
	public String getNom(){
		return this.nom.getText();
	}

}
