package cartes;

public abstract class Probleme extends Carte {

	private Type type;
	
	protected Probleme(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme probleme) {
			if (this.getClass()==probleme.getClass()) {
				return type==probleme.type;
			}
		}
		return false;
	}
	
}
