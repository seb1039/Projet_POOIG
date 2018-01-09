package interfaceGraphique;

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

import joueur.PropositionIncorrecteException;

public class PropositionsNumeri extends JDialog {

	public int choix;

	public PropositionsNumeri(String propositions) {
		setLayout(new GridLayout(3, 1));

		// Panneau Propositions
		JPanel panneauPropositons = new JPanel();
		panneauPropositons.setLayout(new BoxLayout(panneauPropositons, BoxLayout.X_AXIS));

		JTextArea titrePropositions = new JTextArea("Propositions : ");
		titrePropositions.setEditable(false);

		JTextArea listPropositions = new JTextArea(propositions);
		listPropositions.setEditable(false);
		panneauPropositons.add(titrePropositions);
		panneauPropositons.add(listPropositions);

		// Panneau Choix
		JPanel panneauChoix = new JPanel();
		panneauChoix.setLayout(new BoxLayout(panneauChoix, BoxLayout.X_AXIS));

		JTextArea titreChoix = new JTextArea("Choix : ");
		titrePropositions.setEditable(false);

		JTextArea choixRentre = new JTextArea();
		choixRentre.setEditable(false);
		panneauPropositons.add(titreChoix);
		panneauPropositons.add(choixRentre);

		// Panneau Bouton

		JPanel panneauBoutons = new JPanel();
		panneauBoutons.setLayout(new BoxLayout(panneauBoutons, BoxLayout.X_AXIS));

		// Quitter
		JButton quitter = new JButton("OK");
		quitter.addActionListener(event -> {
			boolean flag;
			do {
				try {
					this.choix = Integer.parseInt(choixRentre.getText());
					flag = false;
				} catch (NumberFormatException e) {
					flag = true;
				}
			} while (flag);
			setVisible(false);
		});
		quitter.setSize(new Dimension(10, 10));

		panneauBoutons.add(quitter);

		// On affiche le tout
		add(panneauPropositons);
		add(panneauBoutons);
		setTitle("Choix Propositions");
		setVisible(true);
		setSize(new Dimension(300, 80));
	}
	public int getChoix() {
		return choix;
	}

}
