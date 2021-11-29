package idao.jpa;

import java.util.List;

import comptes.Employe;

public interface IDAOEmploye extends IDAO<Employe, Integer> {

	public List<Employe> findAllByBar(int id_bar);
	
}
