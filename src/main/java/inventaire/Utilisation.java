package inventaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Utilisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double Volume;
	
	@OneToOne
	@JoinColumn(name="id_ingredient_stock")
	private Stock ingredient;
	
	@ManyToOne
	@JoinColumn(name="id_boisson")
	private Boisson boisson;
	
	public Utilisation() {}

	public Utilisation(double volume, Stock ingredient, Boisson boisson) {
		super();
		Volume = volume;
		this.ingredient = ingredient;
		this.boisson = boisson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVolume() {
		return Volume;
	}

	public void setVolume(double volume) {
		Volume = volume;
	}

	public Stock getIngredient() {
		return ingredient;
	}

	public void setIngredient(Stock ingredient) {
		this.ingredient = ingredient;
	}

	public Boisson getBoisson() {
		return boisson;
	}

	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}

	@Override
	public String toString() {
		return "Utilisation [id=" + id + ", Volume=" + Volume + ", ingredient=" + ingredient + ", boisson=" + boisson
				+ "]";
	}
	
	
}
