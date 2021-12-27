
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import repository.ArticleRepository;
import repository.BarRepository;
import repository.BoissonRepository;
import repository.CompteRepository;
import repository.StockRepository;

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

	public void run(String... args) {
		// initDataBase();
		System.out.println("-----------------------------");
	}

	public void initDataBase() {

	}

}
