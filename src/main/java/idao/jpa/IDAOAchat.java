package idao.jpa;

import java.util.List;

import model.comptes.Client;
import model.fonctionnalitees.Achat;

public interface IDAOAchat extends IDAO<Achat,Integer> {
	
	public List<Achat> findAllByClient(int id);

}
