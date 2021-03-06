package inventaire;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private int id;
	private String nom;
	private double cout;
	
	@Enumerated(EnumType.STRING)
	private TypeArticle type_produit;
	private double volume;
	
	
	@ManyToOne
	@JoinColumn(name="id_fournisseur")
	private Fournisseur fournisseur;
	
	public Article(){}
	
	

	public Article(String nom, double cout, TypeArticle type_produit, double volume, Fournisseur fournisseur) {
		this.nom = nom;
		this.cout = cout;
		this.type_produit = type_produit;
		this.volume = volume;
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
		return type_produit;
	}

	public void setType_produit(TypeArticle type_produit) {
		this.type_produit = type_produit;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", cout=" + cout + ", type_produit=" + type_produit + ", volume="
				+ volume + ", fournisseur=" + fournisseur + "]";
	}


	
}
