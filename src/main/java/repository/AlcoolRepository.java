package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.inventaire.Alcool;

public interface AlcoolRepository extends JpaRepository<Alcool, Long> {

}