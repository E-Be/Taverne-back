package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import model.inventaire.Bar;
import model.inventaire.Boisson;

public interface BoissonRepository extends JpaRepository<Boisson, Long> {

	Optional<Boisson> findByNom(String nom);
	
	Optional<Boisson> findById(Long id);
	
	Optional<Boisson> findByBar(Long id);

	List<Boisson> findAllByBar(Bar bar);	
	

		

}

