package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventaire.Boisson;
import inventaire.Utilisation;
import repository.UtilisationRepository;

@Service
public class UtilisationService {
	
	@Autowired
	UtilisationRepository utilisationRepo;
	
	public List<Utilisation> getAllByBoisson(Boisson boisson){
		Check.checkLong(boisson.getId());
		return utilisationRepo.findAllByBoisson(boisson);
	}

}
