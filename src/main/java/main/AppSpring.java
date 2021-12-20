package main;

import org.springframework.beans.factory.annotation.Autowired;

import repository.ArticleRepository;
import repository.BarRepository;
import repository.BoissonRepository;
import repository.CompteRepository;
import repository.StockRepository;

//initialisation des méthodes et query

public class AppSpring {
	@Autowired
	private ArticleRepository articleRepo;
	@Autowired
	private BarRepository barRepo;
	@Autowired
	private BoissonRepository boissonRepo;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private StockRepository stockRepo;
}
