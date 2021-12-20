package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import config.AppConfig;
import repository.StockRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@Rollback(true)
@Transactional
class TestStockRepo {
	
	@Autowired
	private StockRepository stockRepo;
	
	@Test
	public void testContextSpring() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		assertNotNull(ctx);
	}

	@Test
	void testFindAllLimitNull() {
		assertNotNull(stockRepo.findAllLimitNull());
	}

}
