package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import comptes.Client;
import fonctionnalitees.Achat;

public interface AchatRepository extends JpaRepository<Achat, Long>{

	
	Optional<Achat> findById(Long id);
	
	Optional<Achat> findByDate(LocalDate dateAchat);
	
	Optional<Achat> findByClient(Client client);

}
