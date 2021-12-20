package repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import comptes.Employe;
import fonctionnalitees.Events;
import inventaire.Bar;


public interface EvenementRepository extends JpaRepository<Events,Long> {

	//Recherhe par :

	//Pas besoin car déjà contenu dans l'outil
	//@Query("from Events c where c.id =:id")
	//List<Events> findById(@Param("id") Long id);

	//Jour
	@Query("select distinct Events from Events c where c.jour =:jour")
	Optional<Events> findByLocalDate(@Param("jour") LocalDate jour);
	//Bar
	@Query("from Events c where c.bar=:bar")
	Optional<Events> findByBar(@Param("bar") Bar bar);
	//Employe
	@Query("from Events c where c.emp=:emp")
	Optional<Events> findByEmploye(@Param("emp") Employe emp);



	//Update

	//JOUR
	@Transactional
	@Modifying
	@Query("update Events c set c.jour=:jour where c.id=:id")
	void updateLocalDate(@Param("jour")LocalDate jour, @Param("id") Long id);

	//TIME
	@Transactional
	@Modifying
	@Query("update Events c set c.debut=:debut where c.id=:id")
	void updateLocalTimeDebut(@Param("debut")LocalTime debut, @Param("id") Long id);

	@Transactional
	@Modifying
	@Query("update Events c set c.fin=:fin where c.id=:id")
	void updateLocalTimeFin(@Param("fin")LocalTime fin, @Param("id") Long id);
	//

	//Bar
	@Transactional
	@Modifying
	@Query("update Events c set c.bar=:bar where c.id=:id")
	void updateBar(@Param("bar")Bar bar, @Param("id") Long id);

	//Employe
	@Transactional
	@Modifying
	@Query("update Events c set c.emp=:emp where c.id=:id")
	void updateEmploye(@Param("emp")Employe emp, @Param("id") Long id);

	//Remarque
	@Transactional
	@Modifying
	@Query("update Events c set c.remarque=:remarue where c.id=:id")
	void updateRemarque(@Param("remarque")String remarque, @Param("id") Long id);


	//DELETE

	@Transactional
	@Modifying
	@Query("delete Events c where c.id=:id")
	void deleteById(@Param("id") Long id);




}
