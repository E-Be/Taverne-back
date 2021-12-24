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
import repository.EvenementRepository;

@Service
public class EvenementService {


	@Autowired
	private EvenementRepository evenementRepo;
	@Autowired
	private BarRepository barRepository;
	//@Autowired
	//private EmployeRepository employeRepository;

	//RECHERCHE
	public List<Events> getByJour (LocalDate jour){
		if(jour!=null) {
			return evenementRepo.findByJour(jour);
		}		
		else {
			throw new EvenementException();}
	}

	public Events getByBar (Bar bar) {
		return null;
	}

	public Events getByEmploye(Employe emp){
		return null;
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
//	public void updateLocalTimeFin{
//
//	}
//
//	public void updateBar{
//
//	}
//
//	public void updateEmploye{
//
//	}
//
//	public void updateRemarque{
//
//	}
//
//
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
