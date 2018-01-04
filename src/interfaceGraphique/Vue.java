package interfaceGraphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Vue extends JFrame {
	
	private JPanel panel;
	private Container container;
	private Controleur controleur;
	private Modele modele;

	public Vue() {
		
		controleur = new Controleur(this.modele, this);
		panel = new JPanel();
		GridLayout gl = new GridLayout(10, 10);
		
		container = this.getContentPane();
		
		panel.setLayout(gl);
		
		for(int i = 0; i< 100; i++) {
			JPanel tmp = new JPanel();
			tmp.setBackground(Color.BLACK);
			panel.add(tmp);
			
		}
		
		
		setTitle("Jeu de l'Oie et Numeri");
		setSize(new Dimension(400, 400));
		

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
