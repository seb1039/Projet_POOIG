package interfaceGraphique;

import java.awt.Dimension;

import javax.swing.JTextField;

public class JCases extends JTextField {
	private int numero;
	private String title;
	private Modele modele;
	
	public JCases(int numero, Modele modele){
		super();
		this.modele = modele;
		this.numero = numero;
		this.title = "" + this.numero;
		setName(title);
		setText(title);
		setEditable(false);
		setSize(new Dimension(5, 5));
		setMaximumSize(new Dimension(10,10));
	}
	
	public void majCases(){
		try{
			this.title = modele.getCases(this.numero);
		}catch(NullPointerException np){
			System.out.println(this.modele.toString());
			this.title = "ERROR";
		}
		setText("[ " +this.numero +" " +this.title +" ]");
		setVisible(true);
	}

}
