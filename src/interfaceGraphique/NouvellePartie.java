package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NouvellePartie extends JFrame {

	private int nombreDeJoueur = 2;
	private JPanel haut;

	public NouvellePartie() {
		super();
		setLayout(new BorderLayout());

		this.haut = new JPanel();
		haut.setLayout(new GridLayout(10, 1));
		haut.add(new ChoixPartie());
		haut.add(new PanneauJoueur(1));
		haut.add(new PanneauJoueur(2));
		add(haut);

		// Bouton +1
		JButton plusUn = new JButton("+1");
		plusUn.addActionListener(event -> {
			haut.add(new PanneauJoueur(++nombreDeJoueur));
			setVisible(true);

		});
	plusUn.setSize(new Dimension(10, 10));
	//	plusUn.setMinimumSize(new Dimension(10, 10));
		add(plusUn, BorderLayout.EAST);

		// Bouton Démarrer
		JButton demarrer = new JButton("Let's go");
		demarrer.addActionListener(event -> {
			setVisible(false);
		});
		add(demarrer, BorderLayout.PAGE_END);

		setSize(500, 600);
		setMaximumSize(new Dimension(1920, 1080));
		setVisible(true);
	}

}
