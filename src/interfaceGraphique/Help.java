package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Help extends JFrame {

	public Help() {
		super();
		setLayout(new BorderLayout());
		

		JTextArea aide = new JTextArea();
		aide.setEditable(false);
		aide.setText("Comment créer lancer une partie ?\n \n Après avoir exécuté notre programme, vous vous retrouvez face à une fenêtre affichant un Plateau de jeu de l’Oie et ayant comme Menu (en tête de fenêtre).\nAllez dans File>Nouvelle partie.\nUne fenêtre d’initialisation de partie s’affiche.\nChoisissez dans le menu déroulant le type de partie désirée (Partie du jeu de l’oie et sa version ou partie du jeu du Numeri).\nEcrivez le nom des joueurs participants (au moins 2 ici).\nSi vous voulez ajouter d’autre(s) joueur(s), cliquez sur le bouton « +1 » situé à droite dans la fenêtre.Puis cliquez sur le boutons « Let’s go » en bas dans la fenêtre.\nUne fenêtre affichant le plateau correspondant à la partie choisie apparaît.\n(Pour une partie du jeu du Numeri : Une fenêtre d’initialisation du dé (choix de sa valeur maximale) est aussi apparu \n (simultanément avec la fenêtre affichant le plateau donc elle est cachée derrière celle-ci).\n Choisissez le valeur maximale du dé désirée.\nUne partie de votre choix est lancée.\n\nComment jouer à une partie ?\n\nVous vous retrouvez maintenant devant une fenêtre affichant le plateau de la partie que vous avez lancée.\nPour effectuer un tour, cliquez sur le bouton « Nouveau tour » en bas dans la fenêtre.\n(Pour une partie du jeu du Numeri : Il faut maintenant retourner dans la console qui vous demande le numero de la combinaison de pions le joueur veut avancer)\nLe(s) lancements de dé(s)+ le(s) déplacements des pions concernés pour chaque joueur sont effectués (ie : un tour entier).\nCliquez sur « Nouveau tour » jusqu’à ce que la partie se termine.\n\nComment une partie peut se terminer ?\n\nPour une partie du jeu de l’oie : \n\tSoit un joueur a atteint la dernière case et gagne la partie.\n\tSoit tous les joueurs sont piégés dans des cases et personne ne gagne la partie.\n\tPour une partie du jeu du Numeri :\n\tLes 3 dernières cases sont occupées. Un classement est effectué pour déterminer le gagnant de la partie en fonction du nombre de points de ses pions.\n\nComment quitter le jeu ?\n\n\tAllez dans File>Exit.");

		add(aide);
		// Bouton Quitter 
		JButton quit = new JButton("Quitter");
		quit.addActionListener(event -> {
			
			setVisible(false);
		});
		add(quit, BorderLayout.PAGE_END);

		setSize(500, 600);
		setMaximumSize(new Dimension(1920, 1080));
		setVisible(true);
	}

}
