package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import config.AppConfig;
import model.inventaire.Article;
import model.inventaire.Bar;
import model.inventaire.Stock;
import model.inventaire.TypeArticle;
import repository.ArticleRepository;
import repository.BarRepository;
import repository.StockRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@Rollback(true)
@Transactional
class TestStockRepo {

	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private BarRepository barRepo;
	
	@Autowired
	private ArticleRepository articleRepo;

//	@Test
//	public void testContextSpring() {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//		assertNotNull(ctx);
//	}
	
	@Test
	public void testStockRepo() {
		assertNotNull(stockRepo);
	}

	@Test
	void testFindAllLimitNull() {
		assertNotNull(stockRepo.findAllLimitNull());
	}
	
	@Test
	void testFindTypeArticle() {
		Bar bar = barRepo.findById(1L).get();
		Stock stock = stockRepo.findByTypeArticle(TypeArticle.Biere, bar).get();
		assertEquals(stockRepo.findById(2L).get(),stock);
	}

}
