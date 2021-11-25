package comptes;

import javax.persistence.Entity;

import fonctionnalitees.CarteFidelite;

@Entity
public class Client extends Compte {
	
	private CarteFidelite carte;

	public Client() {}
	
	public Client(int id, String nom, String prenom, String login, String password, String mail) {
		super(id, nom, prenom, login, password, mail);
	}
	
	public Client(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
	}
	
	public Client(int id, String nom, String prenom, String login, String password, String mail, CarteFidelite carte) {
		super(id, nom, prenom, login, password, mail);
		this.carte = carte;
	}

	public CarteFidelite getCarte() {
		return carte;
	}

	public void setCarte(CarteFidelite carte) {
		this.carte = carte;
	}
	
	
}
