package idao.jpa;

import model.inventaire.LogAlerte;
import model.inventaire.Stock;

public interface IDAOLogAlerte extends IDAO<LogAlerte, Integer> {

	
	public void creerAlerte(Stock stock);
}
