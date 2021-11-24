package inventaire;

public class Bar {
	
	private int id_bar;
	private int limite;  //Limite du stock a ne pas dépasser sous peine d'être à court de marchandise
	private int qte; //Quantité de produits accessibles dans le stock
	
	
	public Bar(int id_bar, int limite, int qte) {
		
		this.id_bar=id_bar;
		this.limite = limite;
		this.qte = qte;
		
	}
	

	public int getId_bar() {
		return id_bar;
	}

	public void setId_bar(int id_bar) {
		this.id_bar = id_bar;
	}
	
	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

}
