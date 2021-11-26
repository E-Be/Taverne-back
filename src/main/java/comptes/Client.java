package comptes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fonctionnalitees.Achat;
import fonctionnalitees.CarteFidelite;

@Entity
public class Client extends Compte {
	
	@OneToOne
	private CarteFidelite carte;
	
	@OneToMany
	private List<Achat> achats;

	public Client() {}
	
	public Client(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
	}
	
	public Client(String nom, String prenom, String login, String password, String mail, CarteFidelite carte) {
		super(nom, prenom, login, password, mail);
		this.carte = carte;
	}

	public CarteFidelite getCarte() {
		return carte;
	}

	public void setCarte(CarteFidelite carte) {
		this.carte = carte;
	}
	
	
}
