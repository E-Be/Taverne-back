package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import comptes.Admin;
import comptes.Compte;
import config.AppConfig;
import repository.CompteRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@Rollback(false)
@Transactional
class TestCompteRepo {

	@Autowired
	private CompteRepository compteRepo;

	@Test
	void testCompteRepo() {
		assertNotNull(compteRepo);
	}
	
	@Test
	void testFindCompte() {
		// @formatter:off	
		assertAll("Controle des findTypeCompte",
				() -> assertNotNull(compteRepo.findAdmin()),
				() -> assertNotNull(compteRepo.findClient()),
				() -> assertNotNull(compteRepo.findEmploye()),
				() -> assertNotNull(compteRepo.findFournisseur()),
				() -> assertNotNull(compteRepo.findIntervenant()));
				// @formatter:on	
	}
	
	@Test
	void testUpdateAttribute() {
		Compte newCompte = new Admin("TestUpdateNom", "TestUpdatePrenom", "TestUpdateLogin", "TestUpdatePassword", "TestUpdateMail");
		compteRepo.save(newCompte);
		Compte cFromDB = compteRepo.findByNom("TestUpdateNom").get(0);
		// @formatter:off	
		assertAll("controle des donnees du compte inseré", 
				() -> assertEquals("TestUpdateNom", cFromDB.getNom()),
				() -> assertEquals("TestUpdatePrenom", cFromDB.getPrenom()), 
				() -> assertEquals("TestUpdateMail", cFromDB.getMail()),
				() -> assertEquals("TestUpdateLogin", cFromDB.getLogin()),
				() -> assertEquals("TestUpdatePassword", cFromDB.getPassword()));
		// @formatter:on
		compteRepo.updateNom(cFromDB.getId(), "TestUpdateNom2");
		compteRepo.updatePrenom(cFromDB.getId(), "TestUpdatePrenom2");
		compteRepo.updateMail(cFromDB.getId(), "TestUpdateMail2");
		compteRepo.updateLogin(cFromDB.getId(), "TestUpdateLogin2");
		compteRepo.updatePassword(cFromDB.getId(), "TestUpdatePassword2");
//		Long id = cFromDB.getId();
//		if (compteRepo.findById(id) != null) {
//			Compte cFromDB2 = compteRepo.findById(id).get();
//			// @formatter:off
//			assertAll("Controle des updates",
//					() -> assertEquals("TestUpdateNom2", cFromDB2.getNom()),
//					() -> assertEquals("TestUpdatePrenom2", cFromDB2.getPrenom()), 
//					() -> assertEquals("TestUpdateMail2", cFromDB2.getMail()),
//					() -> assertEquals("TestUpdateLogin2", cFromDB2.getLogin()),
//					() -> assertEquals("TestUpdatePassword2", cFromDB2.getPassword()));
//			// @formatter:on
//		}
		
	}
	
	
	
	

}
