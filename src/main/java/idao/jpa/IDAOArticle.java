package idao.jpa;

import java.util.List;

import model.inventaire.Article;

public interface IDAOArticle extends IDAO<Article, Integer> {
	
	public List<Article> findAllByTypeProduit (String typeProduit);
	
	public List<Article> findAllByFournisseur (int id_fournisseur);

}
