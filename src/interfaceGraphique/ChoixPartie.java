package interfaceGraphique;


import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ChoixPartie extends JPanel{

	private String[] choix = {"Partie Oie 1","Partie Oie 2","Partie Oie 3","Partie Numeri"}; 
	private JComboBox<String> nom;
	
	public ChoixPartie(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); 
		
		this.nom = new JComboBox<>(choix);
		nom.setEditable(false);
		nom.setMaximumRowCount(4);
		
		JTextArea typeDePartie = new JTextArea();
		typeDePartie.setEditable(false);
		typeDePartie.setText("Type : ");
		
		add(typeDePartie);
		add(nom);
		setVisible(true);
	}
	
	public String getSelectedItem(){
		return (String) this.nom.getSelectedItem();
	}

}
