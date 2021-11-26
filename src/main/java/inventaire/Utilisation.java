package inventaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utilisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double Volume;
	
	@OneToOne
	private Stock ingredient;
	
	@OneToOne
	private Boisson boisson;
}
