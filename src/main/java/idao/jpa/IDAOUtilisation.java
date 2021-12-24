package idao.jpa;

import java.util.List;

import model.inventaire.Utilisation;

public interface IDAOUtilisation extends IDAO<Utilisation, Integer> {

	public List<Utilisation> findAllByBoisson(int id);
}
