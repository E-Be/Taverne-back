package idao.jpa;

import java.util.List;

import model.fonctionnalitees.Intervention;
import model.fonctionnalitees.StatutIntervention;
import model.inventaire.Bar;

public interface IDAOIntervention extends IDAO <Intervention,Integer>{

	
	public List<Intervention> findByArtiste (String artiste);
	
	public List<Intervention> findAllByStatutAndBar(StatutIntervention statut, Bar bar);
	
}
