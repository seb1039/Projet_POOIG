package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class Vue extends JFrame {
	
	private JPanel panel;
	private JMenuBar menu;
	private JPlateau plateau;
	private Button nvTour;
	
	private Container container;
	private Controleur controleur;
	private Modele modele;

	public Vue() {
		
		
		//Controleur et Container
		controleur = new Controleur(this.modele, this);
		container = this.getContentPane();
		
		//Création du Layout
		setLayout(new BorderLayout());
		
		//Création de la Barre de Menu
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(event ->
		{
			System.exit(JFrame.EXIT_ON_CLOSE);
		});
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(event ->
		{
			new NouvellePartie();
		});
		file.add(newGame);
		file.add(exit);
		this.menu = new JMenuBar();
		menu.add(file);
		menu.setMaximumSize(new Dimension(1080, 20));
		
		// Bouton Nouveau Tour
		this.nvTour = new  Button("Nouveau Tour");
		
		
		// Remplissage de l'IG
		this.plateau = new JPlateau();
		setJMenuBar(menu);
		add(this.plateau);
		add(this.nvTour,BorderLayout.SOUTH);
		
		//Paramétrage de la fenêtre
		setTitle("Jeu de l'Oie et Numeri");
		setSize(new Dimension(320, 320));
		setMaximumSize(new Dimension(1920, 1080));
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Palette palette = new Palette();
			}
		});
	}

}
