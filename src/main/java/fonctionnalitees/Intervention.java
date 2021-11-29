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
import inventaire.Bar;

@Entity
public class Intervention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime hDebut;
	private LocalDateTime hFin;
	///////
	private String typeIntervention;
	///////
	@Column(nullable = true)
	private int coutIntervenant;
	@Column(nullable = true)
	private int prixClient;
	
	
	@ManyToOne
	@JoinColumn(name = "id_intervenant", nullable = true)
	private Intervenant intervenant;
	
	
	private Bar bar;
	
	
	public Intervention() {}


	public Intervention(LocalDateTime hDebut, LocalDateTime hFin, String typeIntervention, int coutIntervenant, int prixClient,Bar bar) {
		this.hDebut = hDebut;
		this.hFin = hFin;
		this.typeIntervention=typeIntervention;
		this.coutIntervenant = coutIntervenant;
		this.prixClient = prixClient;
		this.bar=bar;
		
	}


	

	@Override
	public String toString() {
		return "Intervention [id=" + id + ", hDebut=" + hDebut + ", hFin=" + hFin + ", typeIntervention="
				+ typeIntervention + ", coutIntervenant=" + coutIntervenant + ", prixClient=" + prixClient
				+ ", intervenant=" + intervenant + ", bar=" + bar + "]";
	}


	public Bar getBar() {
		return bar;
	}


	public void setBar(Bar bar) {
		this.bar = bar;
	}


	public String getTypeIntervention() {
		return typeIntervention;
	}


	public void setTypeIntervention(String typeIntervention) {
		this.typeIntervention = typeIntervention;
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

	
	
}
