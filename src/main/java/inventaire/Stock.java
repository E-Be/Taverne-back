package inventaire;


public class Stock extends Catalogue {

	private int id_stock;
	private int id_produit_catalogue;
	private int qte;
	private int qte_litres;
	private int seuil_limite;
	
	public Stock(int id_stock, int id_produit_catalogue, int qte, int qte_litres, int seuil_limite) {
		super(id_produit_catalogue);
		this.id_stock = id_stock;
		this.qte = qte;
		this.qte_litres = qte_litres;
		this.seuil_limite=seuil_limite;
	}

	public int getId_stock() {
		return id_stock;
	}

	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}

	public int getId_produit_catalogue() {
		return id_produit_catalogue;
	}

	public void setId_produit_catalogue(int id_produit_catalogue) {
		this.id_produit_catalogue = id_produit_catalogue;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getQte_litres() {
		return qte_litres;
	}

	public void setQte_litres(int qte_litres) {
		this.qte_litres = qte_litres;
	}

	public int getSeuil_limite() {
		return seuil_limite;
	}

	public void setSeuil_limite(int seuil_limite) {
		this.seuil_limite = seuil_limite;
	}

	@Override
	public String toString() {
		return "Stock [id_stock=" + id_stock + ", id_produit_catalogue=" + id_produit_catalogue + ", qte=" + qte
				+ ", qte_litres=" + qte_litres + ", seuil_limite=" + seuil_limite + "]";
	}
	
	






}
