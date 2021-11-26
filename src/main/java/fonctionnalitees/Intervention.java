package fonctionnalitees;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import comptes.Intervenant;

@Entity
public class Intervention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime hDebut;
	private LocalDateTime hFin;
	private int coutArtiste;
	private int prixClient;
	
	
	@ManyToOne
	private Intervenant intervenant;
	
	
	public Intervention() {}


	public Intervention(LocalDateTime hDebut, LocalDateTime hFin, int coutArtiste, int prixClient) {
		this.hDebut = hDebut;
		this.hFin = hFin;
		this.coutArtiste = coutArtiste;
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


	public int getCoutArtiste() {
		return coutArtiste;
	}


	public void setCoutArtiste(int coutArtiste) {
		this.coutArtiste = coutArtiste;
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
		return "Intervention [id=" + id + ", hDebut=" + hDebut + ", hFin=" + hFin + ", coutArtiste=" + coutArtiste
				+ ", prixClient=" + prixClient + ", intervenant=" + intervenant + "]";
	}
	
	
	
}
