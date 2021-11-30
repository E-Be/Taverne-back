package inventaire;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import comptes.Employe;
import fonctionnalitees.Events;
import fonctionnalitees.Intervention;


@Entity
public class Bar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bar;
	private String nom;
	
	@OneToOne(mappedBy = "bar")
	Stock stock;
	
	@OneToMany (mappedBy = "bar")
	List<Employe> employes;
	
	/////
	@OneToMany(mappedBy = "bar")
	List<Intervention> interventions;
	////
	
	public Bar() {}

	public Bar(String nom, Stock stock, List<Employe> employes,List<Intervention> interventions) {
		this.nom = nom;
		this.stock = stock;
		this.employes = employes;
		this.interventions=interventions;
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

	public Stock getStock() {
		return stock;
	}

	public void setStocks(Stock stocks) {
		this.stock = stocks;
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

	@Override
	public String toString() {
		return "Bar [id_bar=" + id_bar + ", nom=" + nom + ", stocks=" + stock + ", employes="
				+ employes + ", interventions=" + interventions + "]";
	}

	

	

}
