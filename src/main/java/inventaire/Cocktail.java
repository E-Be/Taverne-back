package inventaire;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Alcool")
public class Cocktail extends Boisson{
	
	private List<Article> composants = new ArrayList<Article>();
	
	public Cocktail(String nom, double prixHT, double prixHThh) {
		super(nom, prixHT, prixHThh, TVA.Alcool.tva);
	}
	
	public Cocktail() {
		
	}

	public List<Article> getComposants() {
		return composants;
	}

	public void setComposants(List<Article> composants) {
		this.composants = composants;
	}
	
	


}

