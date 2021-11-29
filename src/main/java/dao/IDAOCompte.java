package dao;

import comptes.Compte;

public interface IDAOCompte extends IDAO<Compte, Integer> {

	
		public Compte connect (String login,String password);
}
