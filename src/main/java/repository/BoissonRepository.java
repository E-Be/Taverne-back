package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import inventaire.Bar;
import inventaire.Boisson;

public interface BoissonRepository extends JpaRepository<Boisson, Long> {

	Optional<Boisson> findByNom(String nom);
	
	Optional<Boisson> findById(Long id);

	List<Boisson> findByBar(Bar bar);
	

}

