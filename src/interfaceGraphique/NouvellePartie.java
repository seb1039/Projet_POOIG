package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NouvellePartie extends JFrame {

	private int nombreDeJoueur = 2;
	private JPanel haut;
	private Modele modele;

	public NouvellePartie(Modele modele) {
		super();
		this.modele = modele;
		setLayout(new BorderLayout());
		
		ChoixPartie cp = new ChoixPartie();
		LinkedList<PanneauJoueur> panneaux = new LinkedList<>();
		panneaux.add(new PanneauJoueur(1));	
		panneaux.add(new PanneauJoueur(2));

		this.haut = new JPanel();
		haut.setLayout(new GridLayout(10, 1));
		haut.add(cp);
		for (PanneauJoueur p: panneaux)
			haut.add(p);
		add(haut);

		// Bouton +1
		JButton plusUn = new JButton("+1");
		plusUn.addActionListener(event -> {
			haut.add(new PanneauJoueur(++nombreDeJoueur));
			setVisible(true);

		});
		plusUn.setSize(new Dimension(10, 10));
		add(plusUn, BorderLayout.EAST);

		// Bouton Démarrer
		JButton demarrer = new JButton("Let's go");
		demarrer.addActionListener(event -> {
			TailleDuDe de;
			if(cp.getSelectedItem().equals("Partie Numeri")){
				de = new TailleDuDe(this.modele);
			}
			String[] nomsDesJoueurs = new String[panneaux.size()];
			int i = 0;
			for(PanneauJoueur p: panneaux){
				nomsDesJoueurs[i] = p.getNom();
				i++;
			}
			modele.init(cp.getSelectedItem(), nomsDesJoueurs);
			setVisible(false);
		});
		add(demarrer, BorderLayout.PAGE_END);

		setSize(500, 600);
		setMaximumSize(new Dimension(1920, 1080));
		setVisible(true);
	}

}
