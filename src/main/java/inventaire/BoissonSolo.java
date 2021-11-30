package inventaire;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Soft")
public class BoissonSolo extends Boisson {
	
	protected Article source;
	protected int quantite;
	protected int seuilLimite;


	public BoissonSolo(String nom,double prixHT,double prixHThh, TVA tva) {
		super(nom,prixHT,prixHThh, tva.tva);
	}	
	
	public BoissonSolo() {}
	
	
}
