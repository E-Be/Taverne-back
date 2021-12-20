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
		compagnonRepo.deleteByMaitre(BoissonEnBase);
		BoissonRepo.delete(BoissonEnBase);
	}

	// recuperation

	public Boisson getBy(Long id) {
		Check.checkLong(id);
		return BoissonRepo.findById(id).orElseThrow(BoissonException::new);
	}

//	private void checkId(Long id) {
//		if (id == null) {
//			throw new BoissonException();
//		}
//	}

	public Boisson getByIdWithQuetes(Long id) {
		Check.checkLong(id);
		return BoissonRepo.findByIdWithQuetes(id).orElseThrow(BoissonException::new);
	}

	public Boisson getByIdWithInventaire(Long id) {
		Check.checkLong(id);
		return BoissonRepo.findByIdWithInventaire(id).orElseThrow(BoissonException::new);
	}

	public Boisson getByIdWithInventaireAndQuetes(Long id) {
		Check.checkLong(id);
		return BoissonRepo.findByIdWithInventaireAndQuetes(id).orElseThrow(BoissonException::new);
	}

	public List<Boisson> getAll() {
		return BoissonRepo.findAll();
	}
}
