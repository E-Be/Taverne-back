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
import model.comptes.Client;
import model.inventaire.Article;
import model.inventaire.Bar;
import model.inventaire.Boisson;
import model.inventaire.Stock;
import model.inventaire.TypeArticle;
import repository.AchatRepository;
import repository.ArticleRepository;
import repository.BarRepository;
import repository.BoissonRepository;
import repository.ClientRepository;
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

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private BoissonRepository boissonRepo;
	
	@Autowired
	private AchatRepository achatRepo;

	@Test
	void testApprovisionner() {
		Article article = articleRepo.findById(1L).orElseThrow(RuntimeException::new);
		Bar bar = barService.getById(1L);
		double volumeAvant = stockService.getByTypeArticle(article.getTypeProduit(), bar).getVolumeTot();
		barService.approvisionner(article, bar);
		double volumeApres = stockService.getByTypeArticle(article.getTypeProduit(), bar).getVolumeTot();
		assertEquals(volumeAvant + article.getVolume(), volumeApres);
	}

	@Test
	void testAchatBoisson() {
		Bar bar = barService.getById(1L);
		Client client = clientRepo.findById(10L).get();
		Boisson boisson = boissonRepo.findById(1L).get();
		double volumeAvant = stockService.getByTypeArticle(TypeArticle.Biere, bar).getVolumeTot();
		barService.achatBoisson(client, boisson);
		double volumeApres = stockService.getByTypeArticle(TypeArticle.Biere, bar).getVolumeTot();
		assertEquals(volumeAvant-0.25, volumeApres);
	}

}
