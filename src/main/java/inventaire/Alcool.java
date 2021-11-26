package inventaire;
import javax.persistence.Entity;

@Entity
public class Alcool extends Boisson{
	
	
	public Alcool(String nom, double prixHT, double prixHThh) {
		super(nom, prixHT, prixHThh,1.2);
	}
	
	public Alcool() {
		
	}


}

