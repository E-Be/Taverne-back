package idao.jpa;


import java.util.List;

import inventaire.Boisson;

public interface IDAOBoisson extends IDAO<Boisson,Integer> {

	public List<Boisson> findAllByBar(int id);
	
}
