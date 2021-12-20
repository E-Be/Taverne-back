package service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventaire.LogAlerte;
import inventaire.Stock;
import repository.LogAlertRepository;

@Service
public class LogAlertService {
	
	@Autowired
	private LogAlertRepository logAlertRepo;
	
	public void creerAlerte(Stock stock) {
		Check.checkLong(stock.getIdStock());
		logAlertRepo.save(new LogAlerte(stock, LocalDateTime.now()));
	}

}
