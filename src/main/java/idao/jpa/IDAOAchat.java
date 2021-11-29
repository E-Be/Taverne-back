package idao.jpa;

import java.util.List;

import fonctionnalitees.Achat;
import comptes.Client;

public interface IDAOAchat extends IDAO<Achat,Integer> {
	
	public List<Achat> findAllByClient(int id);

}
