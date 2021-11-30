package idao.jpa;

import inventaire.LogAlerte;
import inventaire.Stock;

public interface IDAOLogAlerte extends IDAO<LogAlerte, Integer> {

	
	public void creerAlerte(Stock stock);
}
