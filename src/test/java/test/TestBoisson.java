package test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import main.AppSpring;
import inventaire.Boisson;
import repository.BoissonRepository;

public class TestBoisson {
	
	private static AnnotationConfigApplicationContext ctx;
	private BoissonRepository boissonRepo;

	@BeforeClass
	public static void methodeExecutee1FoisAvantLesTests() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterClass
	public static void execution1FoisApresLesTests() {
		ctx.close();
	}

	@Before
	public void execution1FoisAvantCHAQUETest() {
		boissonRepo = ctx.getBean(BoissonRepository.class);
	}

	@After
	public void execution1FoisApresChaqueTest() {

	}

	@Test
	public void personneRepositoryOk() {
		assertNotNull(boissonRepo);
	}

	
	}


