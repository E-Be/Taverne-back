package comptes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fonctionnalitees.Intervention;

@Entity
public class Intervenant extends Compte {
	
	private String entreprise;
	
	/*
	@OneToMany
	private List<Intervention> interventions;
	*/
	
	public Intervenant() {}

	public Intervenant(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
	}
	
	public Intervenant(String nom, String prenom, String login, String password, String mail, String entreprise) {
		super(nom, prenom, login, password, mail);
		this.entreprise = entreprise;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	@Override
	public String toString() {
		return "Intervenant [entreprise=" + entreprise + "]";
	}
	
	

}
