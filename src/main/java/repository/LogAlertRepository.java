package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.inventaire.LogAlerte;

public interface LogAlertRepository extends JpaRepository<LogAlerte, Long>{
	
	

}
