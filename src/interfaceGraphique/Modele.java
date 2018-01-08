package interfaceGraphique;

import jeu.Partie;
import jeu.PartieNullException;
import jeu.PartieOie1;
import jeu.PartieOie2;
import jeu.PartieOie3;
import jeu.PartieNumeri;

public class Modele {

	private Partie partieEnCours;
	private int valMax;

	public Modele() {
	}

	public void init(String type, String[] nomsDesJoueurs) {
		switch (type) {
		case "Partie Oie 1":
			this.partieEnCours = new PartieOie1();

			((PartieOie1) this.partieEnCours).initialisation(nomsDesJoueurs);
			break;
		case "Partie Oie 2":
			this.partieEnCours = new PartieOie2();
			((PartieOie2) this.partieEnCours).initialisation(nomsDesJoueurs);
			break;
		case "Partie Oie 3":
			this.partieEnCours = new PartieOie3();

			((PartieOie3) this.partieEnCours).initialisation(nomsDesJoueurs);
			break;
		case "Partie Numeri":
		default:
			this.partieEnCours = new PartieNumeri();
			((PartieNumeri) this.partieEnCours).initialisation(nomsDesJoueurs);
			break;
		}
	}
	

	public void setValMax(int valMax) {
		this.valMax = valMax;
		if(partieEnCours instanceof PartieNumeri)
			((PartieNumeri) this.partieEnCours).setValMaxDe(valMax);
	}

	public void deroulement() {
		try {
			partieEnCours.deroulement();
			if(partieEnCours.estfinie())
				new FinDePartieOie(this,"Il y a un gagnant ! ");
		} catch (NullPointerException np) {
		} catch (PartieNullException pn) {
			new FinDePartieOie(this, "Tout le monde a perdu ! ");
		}
	}

	public String getCases(int i) {
		try {
			return partieEnCours.getP().getCases(i).toString();
		} catch (NullPointerException np) {
			return "";
		}
	}

}
