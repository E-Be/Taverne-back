package idao.jpa;

import java.util.List;

import comptes.Compte;
import comptes.Intervenant;
import fonctionnalitees.Intervention;
import fonctionnalitees.StatutIntervention;

public interface IDAOIntervention extends IDAO <Intervention,Integer>{

	
	public List<Intervention> findByArtiste (String artiste);
	
	public List<Intervention> findAllByStatut(StatutIntervention statut);
	
}
