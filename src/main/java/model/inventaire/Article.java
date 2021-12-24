package model.inventaire;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;import model.JsonViews;
import model.comptes.Fournisseur;

@Entity
@Table(name="Article")
public class Article {

	@JsonView(JsonViews.Common.class)
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private Long id;
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private double cout;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type_produit")
	@JsonView(JsonViews.Common.class)
	private TypeArticle typeProduit;
	@JsonView(JsonViews.Common.class)
	private double volume;
	
	
	@ManyToOne
	@JoinColumn(name="id_fournisseur")
	@JsonView(JsonViews.ArticleWithFournisseur.class)
	private Fournisseur fournisseur;
	
	public Article(){}
	

	public Article(String nom, double cout, TypeArticle type_produit, double volume, Fournisseur fournisseur) {
		this.nom = nom;
		this.cout = cout;
		this.typeProduit = type_produit;
		this.volume = volume;
		this.fournisseur = fournisseur;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	

	public TypeArticle getTypeProduit() {
		return typeProduit;
	}



	public void setTypeProduit(TypeArticle typeProduit) {
		this.typeProduit = typeProduit;
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



	
}
