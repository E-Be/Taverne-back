package fonctionnalitees;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import comptes.Intervenant;

@Entity
public class Intervention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime hDebut;
	private LocalDateTime hFin;
	
	@Column(nullable = true)
	private int coutIntervenant;
	@Column(nullable = true)
	private int prixClient;
	
	
	@ManyToOne
	@JoinColumn(name = "id_intervenant", nullable = true)
	private Intervenant intervenant;
	
	
	public Intervention() {}


	public Intervention(LocalDateTime hDebut, LocalDateTime hFin, int coutArtiste, int prixClient) {
		this.hDebut = hDebut;
		this.hFin = hFin;
		this.coutIntervenant = coutArtiste;
		this.prixClient = prixClient;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime gethDebut() {
		return hDebut;
	}


	public void sethDebut(LocalDateTime hDebut) {
		this.hDebut = hDebut;
	}


	public LocalDateTime gethFin() {
		return hFin;
	}


	public void sethFin(LocalDateTime hFin) {
		this.hFin = hFin;
	}


	public int getCoutIntervenant() {
		return coutIntervenant;
	}


	public void setCoutIntervenant(int coutArtiste) {
		this.coutIntervenant = coutArtiste;
	}


	public int getPrixClient() {
		return prixClient;
	}


	public void setPrixClient(int prixClient) {
		this.prixClient = prixClient;
	}


	public Intervenant getIntervenant() {
		return intervenant;
	}


	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}


	@Override
	public String toString() {
		return "Intervention [id=" + id + ", hDebut=" + hDebut + ", hFin=" + hFin + ", coutArtiste=" + coutIntervenant
				+ ", prixClient=" + prixClient + ", intervenant=" + intervenant + "]";
	}
	
	
	
}
