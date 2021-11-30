package inventaire;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Soft")
public class BoissonSolo extends Boisson {
	
	@OneToMany
	protected List<Article> sources;
	protected int quantite;
	protected int seuilLimite;

	public BoissonSolo(String nom,double prixHT,double prixHThh, TVA tva) {
		super(nom,prixHT,prixHThh, tva.tva);
	}	
	
	public BoissonSolo() {}
	
	
}
