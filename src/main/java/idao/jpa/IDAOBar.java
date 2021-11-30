package idao.jpa;

import comptes.Client;
import fonctionnalitees.Achat;
import inventaire.Article;
import inventaire.Bar;
import inventaire.Boisson;
import inventaire.Stock;

public interface IDAOBar extends IDAO<Bar, Integer> {
	public Stock approvisioner(Article article,Bar bar);
	public Achat achatBoisson(Client client, Boisson boisson);
}
