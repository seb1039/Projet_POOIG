package interfaceGraphique;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class TailleDuDe extends JDialog {

	private Modele modele;

	public TailleDuDe(Modele modele) {

		this.modele = modele;
		setLayout(new FlowLayout());
		setSize(new Dimension(300, 80));

		// Creation Du Curseur
		JSlider curseur = new JSlider(JSlider.HORIZONTAL, 6, 15, 10);
		curseur.setBorder(BorderFactory.createTitledBorder("Valeur max"));
		curseur.setMajorTickSpacing(4);
		curseur.setMinorTickSpacing(2);
		curseur.setPaintTicks(true);
		// Create the label table
		curseur.setPaintLabels(true);

		// Creation du bouton OK
		JButton ok = new JButton("OK");
		ok.addActionListener(event -> {
			System.out.println("" + curseur.getValue());
			this.modele.setValMax((Integer) curseur.getValue());
			setVisible(false);
		});

		// Assemblage
		add(curseur);
		add(ok);

		setVisible(true);

	}

}
