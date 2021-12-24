package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.comptes.Client;
import model.fonctionnalitees.Achat;

public interface AchatRepository extends JpaRepository<Achat, Long>{

	
	Optional<Achat> findById(Long id);
	
	Optional<Achat> findByDateAchat(LocalDate dateAchat);
	
	Optional<Achat> findByClientAndId(Client client, Long id);
	
	List<Achat> findAllByClient(Client client);

}
