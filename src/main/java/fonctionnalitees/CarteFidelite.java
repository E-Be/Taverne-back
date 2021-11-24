package fonctionnalitees;

import comptes.Client;

public class CarteFidelite {
	
	private int id;
	private Client owner;
	private int nbPoints;
	
	public CarteFidelite(Client owner) {
		this.owner = owner;
		this.nbPoints = 0;
		owner.setCarte(this);
	}
	
	public CarteFidelite(int id, Client owner, int points) {
		this.id = id;
		this.owner = owner;
		this.nbPoints = points;
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
	
	
	
	

}
