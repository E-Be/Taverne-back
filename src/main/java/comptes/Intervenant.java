package comptes;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fonctionnalitees.Intervention;

@Entity
@DiscriminatorValue("Intervenant")
public class Intervenant extends Compte {
	
	private String entreprise;
	
	@OneToMany(mappedBy= "intervenant")
	private List<Intervention> interventions;
	
	public Intervenant() {}

	public Intervenant(String nom, String prenom, String login, String password, String mail, String entreprise,
			List<Intervention> interventions) {
		super(nom, prenom, login, password, mail);
		this.entreprise = entreprise;
		this.interventions = interventions;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	@Override
	public String toString() {
		return "Intervenant [entreprise=" + entreprise + ", interventions=" + interventions + "]";
	}

	

}
