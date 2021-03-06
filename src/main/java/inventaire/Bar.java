package inventaire;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import comptes.Employe;
import fonctionnalitees.Events;
import fonctionnalitees.Intervention;


@Entity
public class Bar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bar;
	private String nom;
	
	@OneToMany(mappedBy = "bar")
	List<Stock> stocks;
	
	@OneToMany (mappedBy = "bar")
	List<Events> events;
	
	@OneToMany (mappedBy = "bar")
	List<Employe> employes;
	
	/////
	@OneToMany(mappedBy = "bar")
	List<Intervention> interventions;
	////
	
	public Bar() {}

	public Bar(String nom, List<Stock> stocks, List<Events> events, List<Employe> employes,List<Intervention> interventions) {
		this.nom = nom;
		this.stocks = stocks;
		this.events = events;
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

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
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
		return "Bar [id_bar=" + id_bar + ", nom=" + nom + "]";
	}

	

	

}
