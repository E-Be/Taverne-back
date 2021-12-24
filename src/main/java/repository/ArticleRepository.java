package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.comptes.Fournisseur;
import model.inventaire.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	public List<Article> findAllByTypeProduit(String typeProduit);
	
	public List<Article> findAllByFournisseur(Fournisseur fournisseur);

}
