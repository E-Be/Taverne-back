package fonctionnalitees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import comptes.Client;


@Entity
@Table(name= "Carte_client")
public class CarteFidelite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(mappedBy = "carte")
	private Client owner;
	
	private int nbPoints;
	
	
	public CarteFidelite() {}
	
	public CarteFidelite(Client owner) {
		this.owner = owner;
		this.nbPoints = 0;
		owner.setCarte(this);
	}
	
	public CarteFidelite(Client owner, int points) {
		this.owner = owner;
		this.nbPoints = points;
	}
	
	public Client getOwner() {
		return owner;
	}
	
	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public int getNbPoints() {
		return nbPoints;
	}
	
	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CarteFidelite [id=" + id + ", owner=" + owner + ", nbPoints=" + nbPoints + "]";
	}
	
	
	
	

}
