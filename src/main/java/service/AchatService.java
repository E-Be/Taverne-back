package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import exception.AchatException;
import exception.BoissonException;
import fonctionnalitees.Achat;
import inventaire.Boisson;
import repository.AchatRepository;

public class AchatService {
	@Autowired
	private AchatRepository achatRepo;
	

	public void creation(Achat achat) {
		if (achat.getId() == null) {
			throw new BoissonException();
		}
		achatRepo.save(achat);
	}

	public void suppression(Achat achat) {
		// traitement sur le compagnon
		// delete
		// null maitre
		Achat achatEnBase = achatRepo.findById(achat.getId()).orElseThrow(AchatException::new);
//		boissonRepo.deleteByBar(BoissonEnBase);
		achatRepo.delete(achatEnBase);
	}

	// recuperation


	public List<Achat> getAll() {
		return achatRepo.findAll();
	}

}
