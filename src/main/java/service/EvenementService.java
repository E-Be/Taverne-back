package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import exception.EvenementException;

import model.comptes.Employe;
import model.fonctionnalitees.Events;
import model.inventaire.Bar;
import repository.BarRepository;
import repository.EmployeRepository;
import repository.EvenementRepository;

@Service
public class EvenementService {


	@Autowired
	private EvenementRepository evenementRepo;
	@Autowired
	private BarRepository barRepo;
	@Autowired
	private EmployeRepository employeRepo;

	//RECHERCHE
	
	public List<Events> getAll() {
		return evenementRepo.findAll();
	}

	public Events getById (Long id){
		if(id!=null) {
			return evenementRepo.findById(id).orElseThrow(EvenementException::new);
		}		
		else {
			throw new EvenementException();}
	}

	
	public List<Events> getByJour (LocalDate jour){
		if(jour!=null) {
			return evenementRepo.findByJour(jour);
		}		
		else {
			throw new EvenementException();}
	}

	public List<Events> getByBar (Bar bar) {
		if(bar!=null) {
			return evenementRepo.findByBar(bar);
		}		
		else {
			throw new EvenementException();}
	}

	public List<Events> getByEmploye(Employe emp){
		if(emp!=null) {
			return evenementRepo.findByEmp(emp);
		}		
		else {
			throw new EvenementException();}
	}


	public void creationOuModification(Events evenement) {
		if (evenement.getId() == null) {
			throw new EvenementException();
		}
		evenementRepo.save(evenement);
	}
	
	//On vient chercher l'objet
	public void suppression(Long id) {
		suppression(getById(id));
	}
	//On le supprime
	public void suppression(Events evenement) {
		Events evenementEnBase = null;
		if (evenement.getId() != null) {
			evenementEnBase = evenementRepo.findById(evenement.getId()).orElseThrow(EvenementException::new);
			evenementRepo.delete(evenementEnBase);
		} else {
			throw new EvenementException();
		}
	}
	
	
	
	
//JORDAN : Pas besoin, Repository g�re d�j� (� tester quand m�me)
//	//UPDATE
//	public void updateLocalDate{
//
//	}
//
//	public void updateLocalTimeDebut{
//
//	}
//

//	//DELETE
//
//	public void deleteById{
//
//	}
//
//
//

}
