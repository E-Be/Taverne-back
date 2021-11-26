package inventaire;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Bar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bar;
	private String nom;
	
	/*
	@OneToMany
	List<Stock> stocks;
	*/
	
	public Bar() {	}

	public Bar(int id_bar, String nom, List<Stock> stocks) {
		super();
		this.id_bar = id_bar;
		this.nom = nom;
		//this.stocks = stocks;
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

	@Override
	public String toString() {
		return "Bar [id_bar=" + id_bar + ", nom=" + nom + "]";
	}

	

}
