package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comptes.Compte;
import exception.CompteException;
import repository.CompteRepository;

@Service
public class CompteServive {
	
	@Autowired
	private CompteRepository compteRepo;
	
	public void creation(Compte compte) {
		Check.checkLong(compte.getId());
		Check.checkString(compte.getNom());
		Check.checkString(compte.getPrenom());
		Check.checkString(compte.getLogin());
		Check.checkString(compte.getPassword());
		Check.checkString(compte.getMail());
		compteRepo.save(compte);
	}
	
	public void suppression(Compte compte) {
		Compte compteEnBase = null;
		Check.checkLong(compte.getId());
		compteEnBase = compteRepo.findById(compte.getId()).orElseThrow(CompteException::new);
		compteRepo.deleteById(compteEnBase.getId());
	}
	
}
