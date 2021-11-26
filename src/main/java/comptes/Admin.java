package comptes;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte {
	
	
	public Admin() {}

	public Admin(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
	}

}
