package inventaire;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("BoissonSolo")
public class BoissonSolo extends Boisson {
	
	@OneToMany
	protected List<Article> sources = new ArrayList<Article>();
	protected int quantite;
	protected int seuilLimite;

	public BoissonSolo(String nom,double prixHT,double prixHThh, TypeArticle type) {
		super(nom,prixHT,prixHThh,type);
	}	
	
	public BoissonSolo(String nom,double prixHT,double prixHThh, TypeArticle type, Article source, int qte, int seuil, Bar bar) {
		super(nom,prixHT,prixHThh,type, bar);
		sources.add(source);
		quantite = qte;
		seuilLimite = seuil;
	}	
	
	public BoissonSolo() {}

	public List<Article> getSources() {
		return sources;
	}

	public void setSources(List<Article> sources) {
		this.sources = sources;
	}

	public int getQte() {
		return quantite;
	}

	public void setQte(int quantite) {
		this.quantite = quantite;
	}

	public int getSeuilLimite() {
		return seuilLimite;
	}

	public void setSeuilLimite(int seuilLimite) {
		this.seuilLimite = seuilLimite;
	}
	
	
	
}
