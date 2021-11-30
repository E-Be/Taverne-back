package idao.jpa;

import inventaire.Article;
import inventaire.Bar;
import inventaire.Stock;

public interface IDAOBar extends IDAO<Bar, Integer> {
	public Stock approvisioner(Article article,Bar bar);
}
