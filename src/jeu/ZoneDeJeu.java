package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {
	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private List<Borne> bornes = new ArrayList<>();
	
	public ZoneDeJeu() {
		
	}
	
	
	public int donnerLimitationVitesse() {
		
		if(pileLimite.isEmpty() || pileLimite.getLast().equals(new FinLimite())) {
			return 200;
		}
		else {
			return 50;
		}
	}
	
	public int donnerKmParcourus() {
		int res=0;
		for(Iterator<Borne> iter = bornes.iterator();iter.hasNext();) {
			Borne borne = (Borne) iter.next();
			res+=borne.getKm();
		}
		return res;
	}
	
	public void deposer(Carte c) {
		if(c.getClass().equals(Borne.class)) {
			bornes.add((Borne) c);
		}
		if((c.equals(new DebutLimite()) || (c.equals(new FinLimite())))){
			pileLimite.add((Limite) c);
		}

		if(c instanceof Bataille) {
			pileBataille.add((Bataille) c);
		}
	}
	
	public boolean peutAvancer() {
		return !pileBataille.isEmpty() && pileBataille.getLast().equals(Cartes.FEU_VERT);	
		
	}
	
	
	private boolean estDepotFeuVertAutorise() {
		if (pileBataille.isEmpty()) {
			return true;
		}
		Carte c = pileBataille.getLast();
		return  c.equals(Cartes.FEU_ROUGE) || (c.getClass().equals(Parade.class) && !c.equals(Cartes.FEU_VERT));
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm()<=donnerLimitationVitesse() && donnerKmParcourus()<=1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(limite.getClass().equals(DebutLimite.class)) {
			return pileLimite.isEmpty() || pileLimite.getLast().equals(new FinLimite());
		}
		if(limite.getClass().equals(FinLimite.class)) {
			return !pileLimite.isEmpty() && pileLimite.getLast().equals(new DebutLimite());
		}
		return false;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		Object classe = bataille.getClass();
		if(classe.equals(Attaque.class)) {
			return peutAvancer();
		}
		if(classe.equals(Parade.class)) {
			Bataille sommet = pileBataille.getLast();

			if(bataille.equals(Cartes.FEU_VERT)) {
				return pileBataille.isEmpty() || sommet.equals(Cartes.FEU_ROUGE) || (sommet.getClass().equals(Parade.class) && !sommet.equals(Cartes.FEU_VERT));
			}
			else {
		
				return !pileBataille.isEmpty() && sommet.getClass().equals(Attaque.class) && sommet.getType()==bataille.getType();
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		Object classe = carte.getClass();
		if(carte.equals(Cartes.FEU_VERT)){
			return estDepotFeuVertAutorise();
		}
		if(classe.equals(Borne.class)) {
			return estDepotBorneAutorise((Borne) carte);
		}
		
		if(carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		if(carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		return false;
	}
}
