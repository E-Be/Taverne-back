package inventaire;
import javax.persistence.Entity;

@Entity
public class Soft extends Boisson {


	public Soft(String nom,double prixHT,double prixHThh) {
		super(nom,prixHT,prixHThh,1.1);
	}	
	
	public Soft() {
		
	}
}
