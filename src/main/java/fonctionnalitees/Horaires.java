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

	public Horaires(LocalTime horaire_embauche, LocalTime horaire_debauche, List<Events> events) {
		this.horaire_embauche = horaire_embauche;
		this.horaire_debauche = horaire_debauche;
		this.events = events;
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

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Horaires [id=" + id + ", horaire_embauche=" + horaire_embauche + ", horaire_debauche="
				+ horaire_debauche + ", events=" + events + "]";
	}

	
	
	
}
