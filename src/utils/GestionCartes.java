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
	
	public static void aux(List<Carte> liste1, Carte carte) {
		int i =0;
		System.out.println(carte.getClass());
		for(ListIterator<Carte> iter = liste1.listIterator();iter.hasNext();) {
			Carte c = iter.next();
			if(c.equals(carte)) {
				i++;
			}
		}
		System.out.println("I = "+i);
		
	}
	public static boolean verifierMelange(List<Carte> liste1, List<Carte> liste2) {
		for(ListIterator<Carte> iter = liste1.listIterator();iter.hasNext();) {
			Carte carte = iter.next();
			
			//System.out.println("Fréquence "+carte.toString()+ " 1 :"+Collections.frequency(liste1,carte)+" 2 : "+Collections.frequency(liste2,carte));
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
	
	public static boolean verifierRassemblement(List<Carte> liste) {
		if(liste.size()==1) {
			return true;
		}
		Carte precedent = liste.get(0);
		for(ListIterator<Carte> iter1 = liste.listIterator(1);iter1.hasNext();) {
			Carte carte = iter1.next();

			if(carte!=precedent) {
				for (ListIterator<Carte> iter2 = liste.listIterator(liste.indexOf(carte)); iter2.hasNext();) {
					Carte duplicata = iter2.next();
					if(duplicata.equals(precedent)) {
						return false;
					}
					
				}
			}
			
			precedent=carte;
		}
		return true;
	}
	
}

