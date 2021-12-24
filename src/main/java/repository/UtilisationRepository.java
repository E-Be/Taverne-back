package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.inventaire.Boisson;
import model.inventaire.Utilisation;

@Repository
public interface UtilisationRepository extends JpaRepository<Utilisation, Long>{
	
	public List<Utilisation> findAllByBoisson(Boisson boisson);

}
