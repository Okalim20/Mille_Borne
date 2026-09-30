package utils;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import cartes.Carte;

public class GestionCartes {
	private static Random random = new Random();
	
	public static Carte extraire(List<Carte> liste) {
		
		int i = random.nextInt(0, liste.size());
		return liste.remove(i);
	}
	
	public static Carte extraireAvecIterateur(List<Carte> liste) {
		int i = random.nextInt(0,liste.size());
		ListIterator<Carte> iter = liste.listIterator(i);
		iter.next();
		return iter.remove();
	}
	
	
	public static List<Carte> melanger(List<Carte> liste) {
		return liste;
	}
}
