package inventaire;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Alcool")
public class Cocktail extends Boisson{
	
	
	public Cocktail(String nom, double prixHT, double prixHThh, Bar bar, List<Utilisation> utilisations) {
		super(nom, prixHT, prixHThh,1.2, bar, utilisations);
	}
	
	public Cocktail() {
		
	}


}

