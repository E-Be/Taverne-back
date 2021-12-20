package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import config.AppConfig;
import inventaire.Article;
import inventaire.Bar;
import inventaire.Stock;
import repository.ArticleRepository;
import repository.BarRepository;
import repository.StockRepository;
import service.BarService;
import service.StockService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@Rollback(true)
@Transactional
class TestBarService {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private BarRepository barRepo;
	
	@Autowired
	private BarService barService;
	
	@Autowired
	private ArticleRepository articleRepo;
	
	
	@Test
	void testApprovisionner() {
		Article article = articleRepo.findById(1L).orElseThrow(RuntimeException::new);
		Bar bar= barService.getById(1L);
		double volumeAvant = stockService.getByTypeArticle(article.getTypeProduit(), bar).getVolumeTot();
		barService.approvisionner(article, bar);
		double volumeApres = stockService.getByTypeArticle(article.getTypeProduit(), bar).getVolumeTot();
		assertEquals(volumeAvant+article.getVolume(), volumeApres);
	}

	@Test
	void testAchatBoisson() {
		fail("Not yet implemented");
	}

}
