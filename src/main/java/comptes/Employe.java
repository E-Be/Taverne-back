package comptes;

import javax.persistence.Entity;

@Entity
public class Employe extends Compte {

	
	public Employe() {}
	
	public Employe(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
	}

	
	
}
