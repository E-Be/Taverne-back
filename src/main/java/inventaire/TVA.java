package inventaire;

public enum TVA {
	
	Soft(1.1), Alcool(1.2), Nourriture(1.1);
	
	public final double tva;
	
	private TVA(double tva) {
		this.tva = tva;
	}

}
