package comptes;

import javax.persistence.Entity;

@Entity
public class Fournisseur extends Compte {
	
	private String entreprise;
	
	public Fournisseur() {}
	
	public Fournisseur(int id, String nom, String prenom, String login, String password, String mail, String entreprise) {
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
