package service;

import java.util.List;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.BoissonException;
import inventaire.Boisson;
import repository.BoissonRepository;

//traitment
//service=> quelque chose qui fournit des fonctionnalites
@Service
public class BoissonService {

	@Autowired
	private BoissonRepository BoissonRepo;
	@Autowired
	private BoissonRepository boissonRepo;
	@Autowired
	private BoissonService boissonService;

	public void creation(Boisson Boisson) {
		if (Boisson.getNom() == null) {
			throw new BoissonException();
		}
		BoissonRepo.save(Boisson);
	}

	public void suppression(Boisson Boisson) {
		// traitement sur le compagnon
		// delete
		// null maitre
		Boisson BoissonEnBase = BoissonRepo.findById(Boisson.getId()).orElseThrow(BoissonException::new);
//		boissonRepo.deleteByBar(BoissonEnBase);
		BoissonRepo.delete(BoissonEnBase);
	}

	// recuperation


	public List<Boisson> getAll() {
		return BoissonRepo.findAll();
	}
}
