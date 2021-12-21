package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comptes.Client;
import exception.AchatException;
import exception.BoissonException;
import fonctionnalitees.Achat;
import inventaire.Boisson;
import repository.AchatRepository;


@Service
public class AchatService {
	
	@Autowired
	private AchatRepository achatRepo;
	

	public void creation(Achat achat) {
//		if (achat.getId() == null) {
//			throw new BoissonException();
//		}
		achatRepo.save(achat);
	}

	public void suppression(Achat achat) {
		Achat achatEnBase = achatRepo.findById(achat.getId()).orElseThrow(AchatException::new);
//		boissonRepo.deleteByBar(BoissonEnBase);
		achatRepo.delete(achatEnBase);
	}

	public List<Achat> getAllByClient(Client client){
		Check.checkLong(client.getId());
		return achatRepo.findAllByClient(client);
	}

	public List<Achat> getAll() {
		return achatRepo.findAll();
	}

}
