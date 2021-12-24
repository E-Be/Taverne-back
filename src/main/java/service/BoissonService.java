package service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.BoissonException;
import model.inventaire.Bar;
import model.inventaire.Boisson;
import repository.BarRepository;
import repository.BoissonRepository;


//traitment
//service=> quelque chose qui fournit des fonctionnalites
@Service
public class BoissonService {

	@Autowired
	private BoissonRepository BoissonRepo;
	@Autowired
	private BarRepository barRepo;
//	@Autowired 
//	private BarService barService;
	
	public void creation(Boisson boisson) {
		if (boisson.getNom() == null) {
			throw new BoissonException();
		}
		BoissonRepo.save(boisson);
	}

	public void suppression(Boisson boisson) {
		//Check.checkLong(boisson.getId());
		Boisson BoissonEnBase = BoissonRepo.findById(boisson.getId()).orElseThrow(BoissonException::new);
//		boissonRepo.deleteByBar(BoissonEnBase);
		BoissonRepo.delete(BoissonEnBase);
	}
	
//	private static boolean happyHour() {
//		if (LocalTime.now().isAfter(LocalTime.parse("17:00:00")) && LocalTime.now().isBefore(LocalTime.parse("21:00:00"))) {
//			return true;
//		} else {return false;}	
//	}
	
//	public static void consulterCartes() {
//
//		//Boisson boissonEnBase = BoissonRepo.findAllByBar(boisson.getId()).orElseThrow(BoissonException::new);
//		
//		if (happyHour()) {
//
//			
//			for(Boisson boisson : BoissonRepo.findAllByBar(boisson.getBar().getId_bar())) 
//			{
//				System.out.println(boisson.getNom()+ "prix: " + (boisson.getPrixHThh())*1.2);
//			}
//			
//		}
//
//		else {
//
//			for(Boisson boisson : BoissonRepo.findAllByBar(boisson.getBar().getId_bar())) 
//			{
//				System.out.println(boisson.getNom()+ "prix: " + (boisson.getPrixHT())*1.2);
//			}
//		}
//	}

	// recuperation


	public List<Boisson> getAllByBar(Bar bar) {
		Check.checkLong(bar.getIdBar());
		return BoissonRepo.findAllByBar(bar);
	}
	
	
}
