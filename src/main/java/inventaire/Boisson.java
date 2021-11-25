package inventaire;
import inventaire.Bar;
import javax.persistence.Entity;
import javax.persistence.Entity;


@Entity
public abstract class Boisson extends Bar {
	
	protected int id;
	protected String nom;
	protected String type_produit;
	protected double prixHT;
	protected double prixHThh;
	protected double tva;
	
	//Creer objet bar
	
	Bar b = new Bar();

	public Boisson (int id, String nom, double prixHT,double prixHThh,double tva){
		this.id=id;
		this.nom=nom;
		this.prixHT=prixHT;
		this.prixHThh=prixHThh;
		this.tva=tva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public double getPrixHThh() {
		return prixHThh;
	}

	public void setPrixHThh(double prixHThh) {
		this.prixHThh = prixHThh;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}
	
}
