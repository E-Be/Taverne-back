package comptes;

import javax.persistence.Entity;

@Entity
public class Employe extends Compte {

	
	public Employe() {}
	
	public Employe(int id, String nom, String prenom, String login, String password, String mail) {
		super(id, nom, prenom, login, password, mail);
	}

	
	
}
