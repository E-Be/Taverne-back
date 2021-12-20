package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comptes.Compte;
import exception.CompagnonException;
import repository.CompteRepository;

@Service
public class CompteServive {
	
	@Autowired
	private CompteRepository compteRepo;
	
	public void creation(Compte compte) {
		if (compte.getNom() == null) {
			throw new CompagnonException();
		}
	}
	
}
