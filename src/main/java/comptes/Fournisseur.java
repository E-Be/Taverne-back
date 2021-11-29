package comptes;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import inventaire.Article;

@Entity
@DiscriminatorValue("Fournisseur")
public class Fournisseur extends Compte {
	
	private String entreprise;
	

	@OneToMany(mappedBy = "fournisseur")
	List<Article> catalogue;
	
	public Fournisseur() {}

	public Fournisseur(String nom, String prenom, String login, String password, String mail, String entreprise,
			List<Article> catalogue) {
		super(nom, prenom, login, password, mail);
		this.entreprise = entreprise;
		this.catalogue = catalogue;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public List<Article> getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(List<Article> catalogue) {
		this.catalogue = catalogue;
	}

	@Override
	public String toString() {
		return "Fournisseur [entreprise=" + entreprise + ", catalogue=" + catalogue + "]";
	}
	
	
	

}
