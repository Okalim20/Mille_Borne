package jeu;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;
	


	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		this.nom=nom;
		this.zoneDeJeu=zoneDeJeu;
	}
	
	public MainJoueur getMain() {
		return main;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		main.prendre(carte);
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zoneDeJeu.deposer(c);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return this.nom==joueur.nom;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
}
