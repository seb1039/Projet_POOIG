package interfaceGraphique;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controleur implements ChangeListener {
	
	private Modele modele;
	private Vue vue;

	public Controleur(Modele modele, Vue vue) {
		super();
		this.modele = modele;
		this.vue = vue;
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {

	}

}
