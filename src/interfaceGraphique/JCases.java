package interfaceGraphique;

import java.awt.Dimension;

import javax.swing.JTextField;

public class JCases extends JTextField {
	private int numero;
	private String title;
	
	public JCases(int numero){
		super();
		this.numero = numero;
		this.title = "" + this.numero;
		setEditable(false);
		setName(title);
		setText(title);
		setSize(new Dimension(5, 5));
		setMaximumSize(new Dimension(10,10));
	}

}
