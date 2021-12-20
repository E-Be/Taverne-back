package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.CompagnonException;
import exception.EvenementException;
import fonctionnalitees.Events;
import repository.BarRepository;
import repository.EvenementRepository;

@Service
public class EvenementService {


	@Autowired
	private EvenementRepository evenementRepo;
	@Autowired
	private BarRepository barRepository;
	@Autowired
	private EmployeRepository employeRepository;

	//RECHERCHE
	public List<Events> findByLocalDate (LocalDate jour){
		if(jour!=null) {
			return evenementRepo.findByLocalDate(jour);
		}		
		else {
			throw new EvenementException();}
	}

	public findByBar (Bar bar) {

	}

	public findByEmploye{

	}


//JORDAN : Pas besoin, Repository gère déjà (à tester quand même)
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
