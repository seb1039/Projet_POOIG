package interfaceGraphique;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPlateau extends JPanel {

	public JPlateau() {
		super();
		GridLayout gl = new GridLayout(8, 8);

		setLayout(gl);

		for (int i = 0; i < 64; i++)
			add(new JCases(i));

		setSize(new Dimension(200, 200));
		setMaximumSize(new Dimension(650, 650));
	}

}
