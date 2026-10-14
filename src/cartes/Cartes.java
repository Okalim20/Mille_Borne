package cartes;

public interface Cartes {
	final Carte PRIORITAIRE = new Botte(Type.FEU);
	final Carte FEU_ROUGE = new Attaque(Type.FEU);
	final Carte FEU_VERT = new Parade(Type.FEU);
	
}
