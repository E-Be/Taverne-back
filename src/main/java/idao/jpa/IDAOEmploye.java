package idao.jpa;

import java.time.LocalTime;
import java.util.List;

import model.comptes.Employe;

public interface IDAOEmploye extends IDAO<Employe, Integer> {

	public List<Employe> findAllByBar(int id_bar);
	
	public List<Employe> findAllByHoraire(LocalTime heure);
	
}
