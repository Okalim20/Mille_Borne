package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import cartes.Carte;

public class GestionCartes {
	
	 private GestionCartes() {
	   /* This utility class should not be instantiated */
	 }

	private static Random random = new Random();
	
	public static Carte extraire(List<Carte> liste) {
		
		int i = random.nextInt(0, liste.size());
		return liste.remove(i);
		
	}
	
//	public static Carte extraireAvecIterateur(List<Carte> liste) {
//		int i = random.nextInt(0,liste.size());
//		ListIterator<Carte> iter = liste.listIterator(i);
//		iter.next();
//		return iter.remove();
//	}
	
	
	public static List<Carte> melanger(List<Carte> liste) {
		List<Carte> listeMelangee = new ArrayList<>();
		int tailleListe = liste.size();
		for (int i = 0; i < tailleListe; i++) {
			listeMelangee.add(extraire(liste));
		}
		return listeMelangee;
		
	}
	

	public static boolean verifierMelange(List<Carte> liste1, List<Carte> liste2) {
		
		if(liste1.size()!=liste2.size()) {
			return false;
		}
		for(ListIterator<Carte> iter = liste1.listIterator();iter.hasNext();) {
			Carte carte = iter.next();
			
			if(Collections.frequency(liste1,carte)!=Collections.frequency(liste2, carte)) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Carte> rassembler(List<Carte> liste){
		List<Carte> listeRassemble = new ArrayList<>();
		
		while(!liste.isEmpty()) {
			Carte premiereOccurence = liste.remove(0);
			listeRassemble.add(premiereOccurence);
			for(ListIterator<Carte> iter = liste.listIterator();iter.hasNext();) {
				Carte carte = iter.next();
				if(carte.equals(premiereOccurence)) {
					listeRassemble.add(carte);
					iter.remove();
				}
			}
		}
		return listeRassemble;

	}
	
	private static boolean verifierDuplicata(Carte carte, List<Carte> liste) {
		for (ListIterator<Carte> iter = liste.listIterator(liste.indexOf(carte)); iter.hasNext();) {
			Carte duplicata = iter.next();
			if(duplicata.equals(carte)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifierRassemblement(List<Carte> liste) {
		if(liste.size()==1) {
			return true;
		}
		boolean bienRassemble = true;
		Carte precedent = liste.get(0);
		for(ListIterator<Carte> iter1 = liste.listIterator(1);iter1.hasNext();) {
			Carte carte = iter1.next();

			if(carte!=precedent) {
				bienRassemble = bienRassemble && verifierDuplicata(precedent, liste);
			}
			
			precedent=carte;
		}
		return bienRassemble;
	}
	
}

