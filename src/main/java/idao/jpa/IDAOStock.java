package idao.jpa;


import java.util.List;

import inventaire.Stock;

public interface IDAOStock extends IDAO<Stock,Integer> {

	public List<Stock> findAllByBar(int id_bar);
	
}
