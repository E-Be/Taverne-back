package inventaire;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import comptes.Employe;
import fonctionnalitees.Events;
import fonctionnalitees.Intervention;
import util.Context;


@Entity
public class Bar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bar;
	private String nom;

	@ManyToMany (mappedBy = "localisations")
	private List<Boisson> stock = new ArrayList<Boisson>();

	@OneToMany (mappedBy = "bar")
	private List<Employe> employes = new ArrayList<Employe>();

	@OneToMany(mappedBy = "bar")
	private List<Intervention> interventions = new ArrayList<Intervention>();

	public Bar() {}
	
	public Bar(String nom) {
		this.nom = nom;
	}

	public Bar(String nom, List<Boisson> stock, List<Employe> employes,List<Intervention> interventions) {
		this.nom = nom;
		this.stock = stock;
		this.employes = employes;
		this.interventions = interventions;
	}

	public int getId_bar() {
		return id_bar;
	}

	public void setId_bar(int id_bar) {
		this.id_bar = id_bar;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Boisson> getStock() {
		return stock;
	}

	public void addArticle(Boisson boisson) {
		stock.add(boisson);
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public boolean addArticle(Article article) {
		if (stock != null) {
			for (Boisson b : stock) {
				if (b instanceof BoissonSolo) {
					for (Article a : ((BoissonSolo)b).getSources()) {
						if (a == article) {
							((BoissonSolo) b).setQte(((BoissonSolo) b).getQte() + a.getQte());
							return true;
						}
					}
				}
			}
		}
		Boisson b = new BoissonSolo(article.getNom(), Context.getInstance().saisieDouble("Prix hors taxe:"), Context.getInstance().saisieDouble("Prix hors taxe en Happy Hour:")
				, article.getType_produit(), article, article.getQte(), Context.getInstance().saisieInt("Saisissez le seuil limite:"), Context.getInstance().getBar() );
		Context.getInstance().getBar().getStock().add(b);
		Context.getInstance().getDaoBoisson().save(b);
		return true;
	}

	@Override
	public String toString() {
		return "Bar [id_bar=" + id_bar + ", nom=" + nom + ", stocks=" + stock + ", employes="
				+ employes + ", interventions=" + interventions + "]";
	}





}
