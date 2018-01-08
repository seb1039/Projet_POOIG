package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FinDePartieNumeri extends JDialog {

	Modele modele;

	public FinDePartieNumeri(Modele modele,String message) {
		this.modele = modele;
		setLayout(new GridLayout(3,1));

		

		// Panneau Classement
		JPanel panneauClassement = new JPanel();
		panneauClassement.setLayout(new BoxLayout(panneauClassement, BoxLayout.X_AXIS));

		JTextArea titreClassement = new JTextArea("Classement : ");
		titreClassement.setEditable(false);

		JTextArea classement = new JTextArea("" +this.modele.getClassement());
		classement.setEditable(false);
		panneauClassement.add(titreClassement);
		panneauClassement.add(classement);

		// Panneau Boutons
		
		JPanel panneauBoutons = new JPanel();
		panneauBoutons.setLayout(new BoxLayout(panneauBoutons, BoxLayout.X_AXIS));
		
		//Rejouer
		JButton rejouer = new JButton("Rejouer");
		rejouer.addActionListener(event -> {
			new NouvellePartie(this.modele);
			setVisible(false);
		});
		rejouer.setSize(new Dimension(10, 10));
		
		
		//Quitter
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(event -> {
			System.exit(JFrame.EXIT_ON_CLOSE);
		});
		quitter.setSize(new Dimension(10, 10));
		
		
		panneauBoutons.add(rejouer);
		panneauBoutons.add(quitter);
		
		// On affiche le tout
		add(panneauClassement);
		add(panneauBoutons);
		setVisible(true);
		setSize(new Dimension(300, 80));
	}
}
