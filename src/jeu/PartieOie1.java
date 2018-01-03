package jeu;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import plateau.*;

public class PartieOie1 extends PartieOie {
	//Arrêt du jeu si dépassement de 63
	
	
	@Override 
	public int finDuJeu(int posCour, int des) {
		return 63;
	}


}


