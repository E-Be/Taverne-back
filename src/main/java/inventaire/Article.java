package inventaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import comptes.Fournisseur;

@Entity
@Table(name="Article")
public class Article {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String nom;
	private double cout;
	private TypeArticle type;
	private int quantite;
	
	
	@ManyToOne
	@JoinColumn(name="id_fournisseur")
	private Fournisseur fournisseur;
	
	public Article(){}
	
	

	public Article(String nom, double cout, TypeArticle type, int volume, Fournisseur fournisseur) {
		this.nom = nom;
		this.cout = cout;
		this.type = type;
		this.quantite = volume;
		this.fournisseur = fournisseur;
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

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public TypeArticle getType_produit() {
		return type;
	}

	public void setType_produit(TypeArticle type) {
		this.type = type;
	}

	public int getVolume() {
		return quantite;
	}

	public void setVolume(int qte) {
		this.quantite = qte;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", cout=" + cout + ", type_produit=" + type + ", volume="
				+ quantite + ", fournisseur=" + fournisseur + "]";
	}


	
}
