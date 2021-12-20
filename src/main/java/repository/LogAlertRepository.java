package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inventaire.LogAlerte;

public interface LogAlertRepository extends JpaRepository<LogAlerte, Long>{
	
	

}
