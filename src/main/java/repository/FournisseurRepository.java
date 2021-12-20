package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import comptes.Fournisseur;
import inventaire.Article;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	
	Optional<Fournisseur> findByNom(String nom);
	
	Optional<Fournisseur> findByMail(String mail);

	Optional<Fournisseur> findByEntreprise(String entreprise);
	
	List<Fournisseur> findByCatalogue(List<Article> catalogue);
}
