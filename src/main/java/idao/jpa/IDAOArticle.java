package idao.jpa;

import java.util.List;

import inventaire.Article;

public interface IDAOArticle extends IDAO<Article, Integer> {
	
	public List<Article> findAllByTypeProduit (String typeProduit);

}
