package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{

	private Carte[] cartes;
	private int nbCartes;
	private int nombreOperations=0;
	
	public Sabot(Carte[] cartes) {
		this.cartes=cartes;
		this.nbCartes=cartes.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Carte carte) {
		if(nbCartes>=cartes.length) {
			throw new IllegalStateException();
		}
		else {
			cartes[nbCartes]=carte;
			nbCartes++;
			nombreOperations++;
		}
	}

	public Carte piocher() {
		Iterator<Carte> iter = new Iterateur();
		Carte carte = iter.next();
		iter.remove();
		return carte;
	}
	

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
				
	private class Iterateur implements Iterator<Carte>{
		private int iteratorPosition=0;
		private boolean nextEffectue=false;
		private int nombreOperationsReference=nombreOperations;
		
		
		private void verificationConcurrence() {
			if(nombreOperations!=nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
		
		@Override
		public boolean hasNext() {
			return nbCartes > iteratorPosition;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				iteratorPosition++;
				nextEffectue=true;
				return cartes[iteratorPosition-1];
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes<1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = iteratorPosition-1; i<nbCartes-1;i++) {
				cartes[i]=cartes[i+1];
			}
			iteratorPosition--;
			nextEffectue=false;
			nbCartes--;
			nombreOperations++;nombreOperationsReference++;
		}
	}
}

