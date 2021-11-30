package inventaire;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Boisson")
public abstract class Boisson{
	
	static List<Boisson> boissons = new ArrayList<Boisson>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String nom;
	protected double prixHT;
	protected double prixHTHappy;
	protected double tva;
	
	
	@ManyToMany
	protected List<Bar> localisations = new ArrayList<Bar>();
	
	public Boisson() {}

	public Boisson(String nom, double prixHT, double prixHTHappy, double tva) {
		this.nom = nom;
		this.prixHT = prixHT;
		this.prixHTHappy = prixHTHappy;
		this.tva = tva;
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
		return prixHTHappy;
	}

	public void setPrixHThh(double prixHThh) {
		this.prixHTHappy = prixHThh;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public double getPrixHTHappy() {
		return prixHTHappy;
	}

	public void setPrixHTHappy(double prixHTHappy) {
		this.prixHTHappy = prixHTHappy;
	}

	public List<Bar> getLocalisations() {
		return localisations;
	}

	public void setLocalisations(List<Bar> localisations) {
		this.localisations = localisations;
	}

	@Override
	public String toString() {
		return "Boisson [id=" + id + ", nom=" + nom + ", prixHT=" + prixHT + ", prixHThh=" + prixHTHappy + ", tva=" + tva
				+ "]";
	}

	
	
	
	
}
