package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comptes.Client;
import exception.BoissonException;
import fonctionnalitees.Achat;
import inventaire.Article;
import inventaire.Bar;
import inventaire.Boisson;
import inventaire.Stock;
import inventaire.Utilisation;
import repository.ArticleRepository;
import repository.BarRepository;
import repository.BoissonRepository;
import repository.StockRepository;

@Service
public class BarService {

	@Autowired
	private BarRepository barRepo;

	@Autowired
	private StockRepository stockRepo;

	@Autowired
	private ArticleRepository articleRepo;

	@Autowired
	private StockService stockService;
	
	@Autowired
	private BoissonRepository boissonRepo;
	
	@Autowired
	private AchatService achatService;
	
	public Bar getById(long id) {
		Check.checkLong(id);
		return barRepo.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public void approvisionner(Article article, Bar bar) {
		try {

			Stock stock = stockService.getByTypeArticle(article.getTypeProduit(), bar);
			stockService.ajouterVolume(article.getVolume(), stock);
			stockRepo.save(stock);

		} catch (Exception e) {
			System.out.println("Voulez vous ajouter un nouveau stock ?");
			stockRepo.save(new Stock(article.getVolume(), null, Arrays.asList(article).stream().collect(Collectors.toSet()), bar));
		}
	}
	
	public void achatBoisson(Client client, Boisson boisson) {
		if (boisson.getUtilisations()==null) {
			throw new BoissonException();
		}
		Set <Utilisation> utils = boisson.getUtilisations();
		for(Utilisation u : utils)
		{
			double volumeUtilise = u.getVolume();
			Stock stock = u.getIngredient();
			stockService.utiliserVolume(volumeUtilise, stock);
		}
		achatService.creation(new Achat(LocalDate.now(), boisson, client));
	}

}
