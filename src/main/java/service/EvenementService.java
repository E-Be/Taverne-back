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
	public List<Employe> getAllEmp() {
		return employeRepo.findAll();
	}

	public List<Bar> getAllBar() {
		return barRepo.findAll();
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
