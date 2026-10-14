package cartes;

public class Borne extends Carte {

	private int km;
	
	public Borne(int km) {
		this.km = km;
	}
	

	@Override
	public String toString() {
		return km+"KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && obj!=null && ((Borne) obj).km==km;
	}

	@Override
	public int hashCode() {
		return 31 * km;
	}


	public int getKm() {
		return km;
	}
}
