package inventaire;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Soft")
public class BoissonSolo extends Boisson {
	
	@OneToMany
	protected List<Article> sources = new ArrayList<Article>();
	protected int quantite;
	protected int seuilLimite;

	public BoissonSolo(String nom,double prixHT,double prixHThh, TypeArticle type) {
		super(nom,prixHT,prixHThh,type);
	}	
	
	public BoissonSolo() {}
	
	
}
