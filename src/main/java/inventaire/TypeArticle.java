package inventaire;

public enum TypeArticle {

	Bière(1.2), Vodka(1.2), Coca(1.1), Limonade(1.1), Eau(1.1), EauGazeuse(1.1), Cocktail(1.2);

	public final double tva;

	private TypeArticle(double tva) {
		this.tva = tva;
	}

}
