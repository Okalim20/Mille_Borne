package utils;

import java.util.List;
import java.util.Random;
import cartes.Carte;

public class GestionCartes {
	private static Random random = new Random();
	
	public static Carte extraire(List<Carte> liste) {
		
		int i = random.nextInt(0, liste.size());
		return liste.get(i);
	}
}
