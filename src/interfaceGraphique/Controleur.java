package interfaceGraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeListener;

import jeu.Partie;
import jeu.PartieNumeri;

public class Controleur implements ActionListener{
	
	private Modele modele;
	private Vue vue;

	public Controleur(Modele modele, Vue vue) {
		super();
		this.modele = modele;
		this.vue = vue;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		modele.deroulement();
		vue.majPlateau();
	}
	
	
}
