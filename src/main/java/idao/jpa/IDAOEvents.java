package idao.jpa;

import java.time.LocalDate;
import java.util.List;

import fonctionnalitees.Events;

public interface IDAOEvents extends IDAO<Events,Integer> {

	public List<Events> findByJour(LocalDate jour);
	
	
}
