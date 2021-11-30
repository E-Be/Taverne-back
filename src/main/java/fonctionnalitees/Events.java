package fonctionnalitees;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import comptes.Employe;
import inventaire.Bar;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_bar")
	private Bar bar;
	
	@ManyToOne
	@JoinColumn(name="id_emp")
	private Employe emp;
	private LocalDate jour;
	private LocalTime debut;
	private LocalTime fin;
	
	@Column(nullable = true)
	private String remarque;
	
	public Events() {}

	public Events(Bar bar, Employe emp, LocalDate jour, LocalTime debut, LocalTime fin, String remarque) {
		this.bar = bar;
		this.emp = emp;
		this.jour = jour;
		this.debut = debut;
		this.fin = fin;
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

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate journee) {
		this.jour = journee;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
	public LocalTime getDebut() {
		return debut;
	}

	public void setDebut(LocalTime debut) {
		this.debut = debut;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", bar=" + bar + ", emp=" + emp + ", jour=" + jour + ", debut=" + debut + ", fin="
				+ fin + ", remarque=" + remarque + "]";
	}
	
	

	
}
