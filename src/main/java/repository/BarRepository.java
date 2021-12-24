package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.inventaire.Bar;

public interface BarRepository extends JpaRepository<Bar, Long>{

}
