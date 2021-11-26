package fonctionnalitees;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import comptes.Employe;
import inventaire.Bar;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Bar bar;
	
	@ManyToOne
	private Horaires horaires;
	
	@ManyToOne
	private Employe emp;
	private LocalDate journee;
	private String remarque;
	
	public Events() {}

	public Events(Bar bar, Horaires horaires, Employe emp, LocalDate journee, String remarque) {
		this.bar = bar;
		this.horaires = horaires;
		this.emp = emp;
		this.journee = journee;
		this.remarque = remarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Horaires getHoraires() {
		return horaires;
	}

	public void setHoraires(Horaires horaires) {
		this.horaires = horaires;
	}

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	public LocalDate getJournee() {
		return journee;
	}

	public void setJournee(LocalDate journee) {
		this.journee = journee;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", bar=" + bar + ", horaires=" + horaires + ", emp=" + emp + ", journee=" + journee
				+ ", remarque=" + remarque + "]";
	}
	
}
