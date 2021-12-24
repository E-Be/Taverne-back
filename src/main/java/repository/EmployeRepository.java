package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.comptes.Employe;

public interface EmployeRepository extends JpaRepository <Employe, Long> {

}
