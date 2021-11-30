package inventaire;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Soft")
public class BoissonSolo extends Boisson {


	public BoissonSolo(String nom,double prixHT,double prixHThh, Bar bar, List<Utilisation> utilisations) {
		super(nom,prixHT,prixHThh,1.1, bar, utilisations);
	}	
	
	public BoissonSolo() {}
	
	
}
