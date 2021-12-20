package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import inventaire.Boisson;

public interface BoissonRepository extends JpaRepository<Boisson, Long> {

	Optional<Boisson> findByNom(String nom);

	List<Boisson> findByBar(String nom);

	List<Boisson> findByAchat(boolean vivant);
	
	List<Boisson> findByUtilisation(boolean vivant);


//	@Query("select distinct personnage from Personnage personnage left join fetch personnage.quetes as quete where personnage.id=:id")
//	Optional<Boisson> findByIdWithQuetes(@Param("id") Long id);
//
//	@Query("select distinct personnage from Personnage personnage left join fetch personnage.inventaire where personnage.id=:id")
//	Optional<Boisson> findByIdWithInventaire(@Param("id") Long id);
//
//	@Query("select distinct personnage from Personnage personnage left join fetch personnage.inventaire left join fetch personnage.quetes where personnage.id=:id")
//	Optional<Boisson> findByIdWithInventaireAndQuetes(@Param("id") Long id);

}

