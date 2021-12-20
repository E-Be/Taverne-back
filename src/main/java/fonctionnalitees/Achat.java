package fonctionnalitees;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import comptes.Client;
import inventaire.Boisson;
//import util.Context;

@Entity
public class Achat {
	
	//static Context context = Context.getInstance();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate dateAchat;
	
	@ManyToOne
	@JoinColumn(name="id_boisson")
	private Boisson boisson;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_client")
	private Client client;

	public Achat() {	}

	public Achat(LocalDate dateAchat, Boisson boisson, Client client) {
		this.dateAchat = dateAchat;
		this.boisson = boisson;
		this.client = client;
	}
	
	public Achat(Boisson boisson) {
		this.dateAchat = LocalDate.now();
		this.boisson = boisson;
		//this.client = (Client)context.getConnected();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Boisson getBoisson() {
		return boisson;
	}

	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateAchat=" + dateAchat + ", boisson=" + boisson + ", client=" + client + "]";
	}
	
	
	
	
}
