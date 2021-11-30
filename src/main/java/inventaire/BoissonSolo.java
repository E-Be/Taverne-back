package inventaire;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Soft")
public class BoissonSolo extends Boisson {
	
	protected int quantite;


	public BoissonSolo(String nom,double prixHT,double prixHThh, TVA tva, List<Utilisation> utilisations) {
		super(nom,prixHT,prixHThh, tva.tva, utilisations);
	}	
	
	public BoissonSolo() {}
	
	
}
