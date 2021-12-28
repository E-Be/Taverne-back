package model.inventaire;
import java.util.Objects;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import model.JsonViews;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Boisson")
public abstract class Boisson{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@JsonView({JsonViews.Common.class,JsonViews.BoissonByBar.class})
	protected Long id;
	@JsonView({JsonViews.Common.class,JsonViews.BoissonByBar.class})
	protected String nom;
	protected double prixHT;
	protected double prixHThh;
	protected double tva;
	
	
	@JsonView(JsonViews.BoissonByBar.class)
	@ManyToOne
	@JoinColumn(name = "id_bar")
	protected Bar bar;
	
	@OneToMany(mappedBy="boisson")
	protected Set<Utilisation> utilisations;
	
	public Boisson() {}

	public Boisson(String nom, double prixHT, double prixHThh, double tva, Bar bar,
			Set<Utilisation> utilisations) {
		this.nom = nom;
		this.prixHT = prixHT;
		this.prixHThh = prixHThh;
		this.tva = tva;
		this.bar = bar;
		this.utilisations = utilisations;
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

	public Set<Utilisation> getUtilisations() {
		return utilisations;
	}

	public void setUtilisations(Set<Utilisation> utilisations) {
		this.utilisations = utilisations;
	}

	@Override
	public String toString() {
		return "Boisson [id=" + id + ", nom=" + nom + ", prixHT=" + prixHT + ", prixHThh=" + prixHThh + ", tva=" + tva
				+ ", bar=" + bar + ", utilisations=" + utilisations + "]";
	}
	
	@Version
	private int version;


	@Override
	public int hashCode() {
		return Objects.hash(bar, id, nom, prixHT, prixHThh, tva, utilisations);
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boisson other = (Boisson) obj;
		return Objects.equals(bar, other.bar) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom)
				&& Double.doubleToLongBits(prixHT) == Double.doubleToLongBits(other.prixHT)
				&& Double.doubleToLongBits(prixHThh) == Double.doubleToLongBits(other.prixHThh)
				&& Double.doubleToLongBits(tva) == Double.doubleToLongBits(other.tva)
				&& Objects.equals(utilisations, other.utilisations);
	}
	
	
	
	
	

	
	
	
	
}
