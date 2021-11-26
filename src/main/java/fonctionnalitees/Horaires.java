package fonctionnalitees;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import comptes.Employe;


@Entity
public class Horaires {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalTime horaire_embauche;
	private LocalTime horaire_debauche;
	
	@OneToMany(mappedBy = "horaires")
	private List<Events> events;
	
	public Horaires() {}

	public Horaires(LocalTime horaire_embauche, LocalTime horaire_debauche) {
		this.id = id;
		this.horaire_embauche = horaire_embauche;
		this.horaire_debauche = horaire_debauche;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getHoraire_embauche() {
		return horaire_embauche;
	}

	public void setHoraire_embauche(LocalTime horaire_embauche) {
		this.horaire_embauche = horaire_embauche;
	}

	public LocalTime getHoraire_debauche() {
		return horaire_debauche;
	}

	public void setHoraire_debauche(LocalTime horaire_debauche) {
		this.horaire_debauche = horaire_debauche;
	}
	
	
}
