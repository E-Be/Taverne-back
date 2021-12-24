package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.BoissonException;
import model.inventaire.Alcool;
import model.inventaire.Bar;
import model.inventaire.Boisson;
import model.inventaire.Soft;
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
	@Autowired 
	private BarService barService;
	
	
	//CREATE
	
	public void create(Boisson boisson) {
		if (boisson.getNom() == null) {
			throw new BoissonException();
		}
		BoissonRepo.save(boisson);
	}
	
	public void create(Alcool alcool) {
		if (alcool.getNom() == null) {
			throw new BoissonException();
		}
		BoissonRepo.save(alcool);
	}
	
	public void create(Soft soft) {
		if (soft.getNom() == null) {
			throw new BoissonException();
		}
		BoissonRepo.save(soft);
	}
	
	//UPDATE
	
	public void update(Boisson boisson) {
		if (boisson.getId() == null) {
			throw new BoissonException();
		}
		Boisson boissonEnBase = getById(boisson.getId());
		boisson.setVersion(boissonEnBase.getVersion());
		
		BoissonRepo.save(boisson);
	}

	public void suppression(Boisson boisson) {
		//Check.checkLong(boisson.getId());
		Boisson BoissonEnBase = BoissonRepo.findById(boisson.getId()).orElseThrow(BoissonException::new);
//		boissonRepo.deleteByBar(BoissonEnBase);
		BoissonRepo.delete(BoissonEnBase);
	}
	
	public void suppression(Long id) {
		suppression(getById(id));
	}
	

	
	public List<Boisson> getAllByBar(Bar bar) {
		return BoissonRepo.findAllByBar(bar);
	}
	
//	public List<Boisson> getAllByBar(Long id) {
//		getAllByBar(getById(id));
//	}
	
	
	public List<Boisson> getAll() {
		return BoissonRepo.findAll();
	}
	
	public Boisson getById(Long id) {
		Check.checkLong(id);
		return BoissonRepo.findById(id).orElseThrow(BoissonException::new);
	}
	
	
}
