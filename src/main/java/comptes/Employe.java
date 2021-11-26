package comptes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fonctionnalitees.Events;
import inventaire.Bar;

@Entity
public class Employe extends Compte {
	
	@ManyToOne
	private Bar bar;
	
	@OneToMany(mappedBy = "emp")
	private List<Events> events;
	
	public Employe() {}
	
	public Employe(String nom, String prenom, String login, String password, String mail) {
		super(nom, prenom, login, password, mail);
	}

	
	
}
