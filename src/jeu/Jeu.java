package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCartes.add(carte);

		}		
		listeCartes=GestionCartes.melanger(listeCartes);
		this.sabot = new Sabot((Carte[]) listeCartes.toArray());

	}
}
