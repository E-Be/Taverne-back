package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.StockException;
import inventaire.Bar;
import inventaire.Stock;
import inventaire.TypeArticle;
import repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepo;
	
	@Autowired
	private LogAlertService logAlerteService;

	public Stock getByTypeArticle(TypeArticle typeArticle, Bar bar) {
		return stockRepo.findByTypeArticle(typeArticle, bar).orElseThrow(StockException::new);
	}

	public void utiliserVolume(double volume, Stock stock) {
		Check.checkLong(stock.getIdStock());
		Check.checkNegatif(volume);
		double newVolume = stock.getVolumeTot() - volume;
		Check.checkNegatif(newVolume);
		stock.setVolumeTot(newVolume);

		try {
			if (newVolume <= stock.getseuilLimite()) {
				logAlerteService.creerAlerte(stock);
			}
		} catch (Exception e) {
		}

	}

	public void ajouterVolume(double volume, Stock stock) {
		Check.checkNegatif(volume);
		Check.checkLong(stock.getIdStock());
		double newVolume = stock.getVolumeTot()+volume;
		stock.setVolumeTot(newVolume);
		stockRepo.save(stock);
	}

}
