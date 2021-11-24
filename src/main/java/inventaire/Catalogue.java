package inventaire;

public class Catalogue {
	
	private int id_produit_catalogue;
	private String Produit;
	private String type_produit;
	private boolean coutHT;
	private int Qte_lot;
	private int Volume;
	private int id_fournisseur;
	
	public Catalogue(int id,String Produit,String type_produit,boolean coutHT,int Qte_lot,int Volume,int id_fournisseur){
	this.id_produit_catalogue=id_produit_catalogue;
	this.Produit=Produit;
	this.type_produit=type_produit;
	this.coutHT=coutHT;
	this.Qte_lot=Qte_lot;
	this.Volume=Volume;
	this.id_fournisseur=id_fournisseur;	
		
	}
	
	public Catalogue(int id_produit_catalogue){
	this.id_produit_catalogue=id_produit_catalogue;
		
	}
	
	
	
	
	
	
	
	
	

}
