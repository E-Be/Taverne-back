package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.CompteException;
import model.comptes.Admin;
import model.comptes.Client;
import model.comptes.Compte;
import model.comptes.Employe;
import repository.AchatRepository;
import repository.BarRepository;
import repository.CarteFideliteRepository;
import repository.CompteRepository;
import repository.EvenementRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepo;

	@Autowired
	private CarteFideliteService carteFideliteService;
	
	@Autowired
	private AchatRepository achatRepo;
	
	@Autowired
	private BarRepository barRepo;
	
	@Autowired
	private EvenementRepository eventsRepo;

	public void creationClient(Client compte) {
		checkCompte(compte);
		compteRepo.save(compte);
	}
	
	public void creationAdmin(Admin compte) {
		checkCompte(compte);
		compteRepo.save(compte);
	}
	
	public void creationEmploye(Employe compte) {
		checkCompte(compte);
		compteRepo.save(compte);
	}
	
	private void checkCompte(Compte compte) {
		Check.checkString(compte.getNom());
		Check.checkString(compte.getPrenom());
		Check.checkString(compte.getLogin());
		Check.checkString(compte.getPassword());
		Check.checkString(compte.getMail());
	}

	public void suppression(Compte compte) {
		Compte compteEnBase = null;
		Check.checkLong(compte.getId());
		compteEnBase = compteRepo.findById(compte.getId()).orElseThrow(CompteException::new);
		compteRepo.deleteById(compteEnBase.getId());
	}

	public void update(Compte compte) {
		if (compte.getId() == null) {
			throw new CompteException();
		}
		Compte compteEnBase = getBy(compte.getId());
		updateRelation(compte);
		compte.setVersion(compteEnBase.getVersion());

		compteRepo.save(compte);
	}

	private void updateRelation(Compte compte) {
		String typeCompte = compte.getClass().getSimpleName();
		switch (typeCompte) {
		case "Admin":
			break;
		case "Client":
			if (((Client) compte).getCarte() != null && ((Client) compte).getCarte().getId() != null) {
				((Client) compte).setCarte(carteFideliteService.getBy(((Client) compte).getCarte().getId()));
			}
			if (((Client) compte).getAchats() != null) {
				((Client) compte).setAchats(achatRepo.findAllByClient((Client)compte));
			}
			break;
		case "Employe":
			if (((Employe) compte).getBar() != null && ((Employe) compte).getBar().getIdBar() != null) {
				((Employe) compte).setBar(barRepo.getById(((Employe) compte).getBar().getIdBar()));
			}
			if (((Employe) compte).getEvents() != null) {
				((Employe) compte).setEvents(eventsRepo.findByEmp((Employe)compte));
			}
			break;

		}
	}

	public Compte getBy(Long id) {
		Check.checkLong(id);
		return compteRepo.findById(id).orElseThrow(CompteException::new);
	}

	public List<Compte> getAll() {
		return compteRepo.findAll();
	}

}
