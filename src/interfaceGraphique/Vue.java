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

import com.sun.org.apache.bcel.internal.generic.POP;

import jeu.Partie;
import jeu.PartieNumeri;

public class Vue extends JFrame {

	private JMenuBar menu;
	private JPlateau plateau;
	private Button nvTour;

	private Container container;
	private Controleur controleur;
	private Modele modele;

	public Vue() {

		// Controleur et Container
		modele = new Modele(this);
		controleur = new Controleur(this.modele, this);
		container = this.getContentPane();

		// Création du Layout
		setLayout(new BorderLayout());

		// Création de la Barre de Menu
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(event -> {
			System.exit(JFrame.EXIT_ON_CLOSE);
		});
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(event -> {
			new NouvellePartie(this.modele);
		});
		file.add(newGame);
		file.add(exit);
		this.menu = new JMenuBar();
		menu.add(file);

		// Bouton Nouveau Tour
		this.nvTour = new Button("Nouveau Tour");
		this.nvTour.addActionListener(controleur);

		// Remplissage de l'IG
		this.plateau = new JPlateauOie(this.modele);
		setJMenuBar(menu);
		add(this.plateau);
		add(this.nvTour, BorderLayout.SOUTH);

		// Paramétrage de la fenêtre
		setTitle("Jeu de l'Oie et Numeri");
		setSize(new Dimension(800, 500));
		setMaximumSize(new Dimension(1920, 1080));

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JPlateau getPlateau(){
		return this.plateau;
	}
	
	public void majPlateau(){
		plateau.majPlateau();
	}
	
	public void majJPlateau(Partie partie){
		this.remove(this.plateau);
		if(partie instanceof PartieNumeri){
			this.plateau= new JPlateauNumeri(this.modele);
		}
		else{
			this.plateau= new JPlateauOie(this.modele);
		}
		add(this.plateau);
		setVisible(true);
	}


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Palette palette = new Palette();
			}
		});
	}

}
