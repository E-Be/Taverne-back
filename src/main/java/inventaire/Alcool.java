package inventaire;
import javax.persistence.Entity;

@Entity
public class Alcool extends Boisson{
	
	
	public Alcool(int id,String nom, double prixHT, double prixHThh) {
		
		super(id, nom, prixHT, prixHThh,1.2);
	}
	
	public Alcool() {
		
	}


}

