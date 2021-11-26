package comptes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import inventaire.Article;

@Entity
public class Fournisseur extends Compte {
	
	private String entreprise;
	
	/*
	@OneToMany
	List<Article> catalogue;
	*/
	
	public Fournisseur() {}
	
	public Fournisseur(String nom, String prenom, String login, String password, String mail, String entreprise) {
		super(nom, prenom, login, password, mail);
		this.entreprise = entreprise;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	

}
