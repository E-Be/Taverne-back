package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comptes.Fournisseur;
import exception.FournisseurException;
import repository.FournisseurRepository;

@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurRepository FournisseurRepo;
	
//	@Autowired 
//	private BarService barService;
	
	public void creation(Fournisseur fournisseur) {
		if (fournisseur.getEntreprise() == null) {
			throw new FournisseurException();
		}
		FournisseurRepo.save(fournisseur);
	}

	public void suppression(Fournisseur fournisseur) {
		// traitement sur le compagnon
		// delete
		// null maitre
		Fournisseur FournisseurEnBase = FournisseurRepo.findById(fournisseur.getId()).orElseThrow(FournisseurException::new);
//		boissonRepo.deleteByBar(BoissonEnBase);
		FournisseurRepo.delete(FournisseurEnBase);
	}
}
