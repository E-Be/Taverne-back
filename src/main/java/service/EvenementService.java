package service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.EvenementException;
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
	public findByLocalDate (LocalDate jour){
		if(jour!=null)
		return evenementRepo.findByLocalDate(jour).orElseThrow(EvenementException::new);
		
		
	}
	
	public findByBar (Bar bar) {
		
	}
	
	public findByEmploye{
		
	}
	
	
	
	//UPDATE
	public void updateLocalDate{
		
	}
	
	public void updateLocalTimeDebut{
		
	}
	
	public void updateLocalTimeFin{
		
	}
	
	public void updateBar{
		
	}
	
	public void updateEmploye{
		
	}
	
	public void updateRemarque{
		
	}
	
	
	
	//DELETE
	
	public void deleteById{
		
	}
	
	
	
	
	
	
//	public void getbyLocaldate(LocalDate jour) {
//		if(jour!=null)
//			return evenementRepo.getbyLocaldate(jour).orElseThrow(EvenementException::new);
//	}

//	public void getById (Long id) {
//		Check.checkLong(id);
//		return evenementRepo.getById(id).orElseThrow(EvenementException::new);
//	}






}
