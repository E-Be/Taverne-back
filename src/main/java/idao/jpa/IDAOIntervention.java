package idao.jpa;

import java.util.List;

import comptes.Compte;
import comptes.Intervenant;
import fonctionnalitees.Intervention;

public interface IDAOIntervention extends IDAO <Intervention,Integer>{

	
	public List<Intervention> findByArtiste (String artiste);
	
	
	
}
