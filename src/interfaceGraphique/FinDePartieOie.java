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

public class FinDePartieOie extends JDialog {

	Modele modele;

	public FinDePartieOie(Modele modele,String message) {
		this.modele = modele;
		setLayout(new GridLayout(3,1));

		// Panneau Cause
		JPanel panneauCause = new JPanel();
		panneauCause.setLayout(new BoxLayout(panneauCause, BoxLayout.X_AXIS));

		JTextArea titreCause = new JTextArea("Cause : ");
		titreCause.setEditable(false);

		JTextArea cause = new JTextArea(message);
		cause.setEditable(false);
		panneauCause.add(titreCause);
		panneauCause.add(cause);

		// Panneau Gagnant
		JPanel panneauGagnant = new JPanel();
		panneauGagnant.setLayout(new BoxLayout(panneauGagnant, BoxLayout.X_AXIS));

		JTextArea titreGagnant = new JTextArea("Gagnant : ");
		titreGagnant.setEditable(false);

		JTextArea Gagnant = new JTextArea("" +this.modele.getCases(63));
		Gagnant.setEditable(false);
		panneauGagnant.add(titreGagnant);
		panneauGagnant.add(Gagnant);

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
		add(panneauCause);
		add(panneauGagnant);
		add(panneauBoutons);
		setVisible(true);
		setSize(new Dimension(300, 80));
	}
}
