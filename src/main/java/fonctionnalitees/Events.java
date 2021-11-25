package fonctionnalitees;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import comptes.Employe;
import inventaire.Bar;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Bar bar;
	private Horaires horaires;
	private Employe emp;
	private Date journee;
	private String remarque;
	
	public Events() {}

	public Events(int id, Bar bar, Horaires horaires, Employe emp, Date journee, String remarque) {
		super();
		this.id = id;
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

	public Horaires getHoraire() {
		return horaires;
	}

	public void setHoraire(Horaires horaires) {
		this.horaires = horaires;
	}

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	public Date getJournee() {
		return journee;
	}

	public void setJournee(Date journee) {
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
		return "Events [id=" + id + ", bar=" + bar + ", emp=" + emp + ", journee=" + journee + ", remarque=" + remarque
				+ "]";
	}
	
	

}
