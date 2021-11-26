package fonctionnalitees;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import comptes.Employe;


@Entity
public class Horaires {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalTime horaire_embauche;
	private LocalTime horaire_debauche;
	
	@ManyToOne
	private Employe emp;
	
	public Horaires() {}

	public Horaires(int id, LocalTime horaire_embauche, LocalTime horaire_debauche, Employe emp) {
		this.id = id;
		this.horaire_embauche = horaire_embauche;
		this.horaire_debauche = horaire_debauche;
		this.emp = emp;
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

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Horaires [id=" + id + ", horaire_embauche=" + horaire_embauche + ", horaire_debauche="
				+ horaire_debauche + ", emp=" + emp + "]";
	}
	
	
	
}
