package comptes;

import javax.persistence.Entity;

@Entity
public class Intervenant extends Compte {
	
	private String entreprise;
	
	public Intervenant() {}

	public Intervenant(int id, String nom, String prenom, String login, String password, String mail) {
		super(id, nom, prenom, login, password, mail);
	}
	
	public Intervenant(int id, String nom, String prenom, String login, String password, String mail, String entreprise) {
		super(id, nom, prenom, login, password, mail);
		this.entreprise = entreprise;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

}
