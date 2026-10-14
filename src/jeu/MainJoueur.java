package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class MainJoueur {

	private List<Carte> listeCarte = new ArrayList<>();
	
	public MainJoueur(Carte[] listeCarte) {

	}
	
	public void prendre(Carte carte) {
		listeCarte.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert(listeCarte.contains(carte));
		listeCarte.remove(carte);
	}
	
	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("Main :\n");
		for(ListIterator<Carte> iter = listeCarte.listIterator();iter.hasNext();) {
			message.append(iter.next().toString());
			message.append("\n");
		}
		return message.toString();
	}
}

