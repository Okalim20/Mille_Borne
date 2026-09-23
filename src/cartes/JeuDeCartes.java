package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes ;
	
	public String affichageJeuDeCartes() {
		StringBuilder message = new StringBuilder();
		for (Configuration configuration : typesDeCartes) {
			message.append(configuration.nbExemplaires+" "+configuration.carte.toString());
		}
		
		return message.toString();
	}
	
	public Carte[] donnerCartes() {
		
	}
	
	private class Configuration extends Carte{
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		public Carte getCarte() {
			return carte;
		}
		
		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
		
	}
}
