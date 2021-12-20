package test;

import static org.junit.jupiter.api.Assertions.fail;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import service.FournisseurService;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class) // remplace @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })

public class TestFournisseurRepo {
	@Autowired
	private FournisseurService FournisseurService;

	@Test
	@Disabled
	void testCreation() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSuppression() {
		fail("Not yet implemented");
	}

}
