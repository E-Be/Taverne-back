package idao.jpa;

import java.util.List;

import model.fonctionnalitees.CarteFidelite;

public interface IDAOCarteFidelite extends IDAO<CarteFidelite,Integer>{
	
	public List<CarteFidelite> findAllByMinPts(int minPts);

}
