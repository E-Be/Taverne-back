package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.inventaire.Bar;
import model.inventaire.Stock;
import model.inventaire.TypeArticle;

public interface StockRepository extends JpaRepository<Stock, Long>{
	
	public List<Stock> findAllByBar(Bar bar);
	
	@Query("from Stock where seuil_limite = null")
	public List<Stock> findAllLimitNull();
	
	@Query("from Stock s join s.articles a where a.typeProduit=:lib and s.bar=:bar")
	public Optional<Stock> findByTypeArticle(@Param ("lib") TypeArticle typeArticle, @Param("bar") Bar bar);

}
