package dao;

import java.util.List;

import comptes.Compte;

public interface IDAOCompte extends IDAO<Compte, Integer> {

	
		public Compte connect (String login,String password);
		
		public List<Compte> findByTypeCompte (String typeCompte);
}
