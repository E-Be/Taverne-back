package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.inventaire.Soft;

public interface SoftRepository extends JpaRepository<Soft, Long> {

}