package idao.jpa;

import java.util.List;

import fonctionnalitees.Intervention;
import fonctionnalitees.StatutIntervention;
import inventaire.Bar;

public interface IDAOIntervention extends IDAO <Intervention,Integer>{

	
	public List<Intervention> findByArtiste (String artiste);
	
	public List<Intervention> findAllByStatutAndBar(StatutIntervention statut, Bar bar);
	
}
