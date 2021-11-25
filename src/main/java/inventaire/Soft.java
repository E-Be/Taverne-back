package inventaire;
import javax.persistence.Entity;

@Entity
public class Soft extends Boisson {


	public Soft(int id,String nom,double prixHT,double prixHThh) {
		super(id,nom,prixHT,prixHThh,1.1);
	}	
	
	public Soft() {
		
	}
}
