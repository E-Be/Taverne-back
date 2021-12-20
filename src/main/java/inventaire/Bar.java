package inventaire;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
	private Long id_bar;
	private String nom;
	
	@OneToMany(mappedBy = "bar")
	Set<Stock> stocks;
	
	@OneToMany (mappedBy = "bar")
	Set<Events> events;
	
	@OneToMany (mappedBy = "bar")
	Set<Employe> employes;
	
	/////
	@OneToMany(mappedBy = "bar")
	Set<Intervention> interventions;
	////
	
	public Bar() {}

	public Bar(String nom, Set<Stock> stocks, Set<Events> events, Set<Employe> employes, Set<Intervention> interventions) {
		this.nom = nom;
		this.stocks = stocks;
		this.events = events;
		this.employes = employes;
		this.interventions=interventions;
	}

	public Long getId_bar() {
		return id_bar;
	}

	public void setId_bar(Long id_bar) {
		this.id_bar = id_bar;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public Set<Events> getEvents() {
		return events;
	}

	public void setEvents(Set<Events> events) {
		this.events = events;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public Set<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}

	@Override
	public String toString() {
		return "Bar [id_bar=" + id_bar + ", nom=" + nom + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_bar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bar other = (Bar) obj;
		return Objects.equals(id_bar, other.id_bar);
	}

	

	

	

}
