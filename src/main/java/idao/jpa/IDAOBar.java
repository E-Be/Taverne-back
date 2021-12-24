package idao.jpa;

import model.comptes.Client;
import model.fonctionnalitees.Achat;
import model.inventaire.Article;
import model.inventaire.Bar;
import model.inventaire.Boisson;
import model.inventaire.Stock;

public interface IDAOBar extends IDAO<Bar, Integer> {
	public Stock approvisioner(Article article,Bar bar);
	public Achat achatBoisson(Client client, Boisson boisson);
}
