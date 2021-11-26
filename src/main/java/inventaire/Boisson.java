package inventaire;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public abstract class Boisson{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String nom;
	protected double prixHT;
	protected double prixHThh;
	protected double tva;
	
	@ManyToOne
	protected Bar bar;
	
	@OneToMany(mappedBy="boisson")
	protected List<Utilisation> utilisations;
	
	public Boisson() {}

	public Boisson (String nom, double prixHT,double prixHThh,double tva){
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

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public List<Utilisation> getUtilisations() {
		return utilisations;
	}

	public void setUtilisations(List<Utilisation> utilisations) {
		this.utilisations = utilisations;
	}

	@Override
	public String toString() {
		return "Boisson [id=" + id + ", nom=" + nom + ", prixHT=" + prixHT + ", prixHThh=" + prixHThh + ", tva=" + tva
				+ ", bar=" + bar + ", utilisations=" + utilisations + "]";
	}
	
	
	
}
