package dao.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import dao.IDAOEvents;
import fonctionnalitees.Events;
import inventaire.Article;
import util.Context;

public class DAOEvents implements IDAOEvents{
	
	
	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Events findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Events objet = em.find(Events.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Events> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Events> objets = em.createQuery("from Events").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Events save(Events objet) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		objet=em.merge(objet);

		em.getTransaction().commit();
		em.close();

		return objet;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		Events objet = em.find(Events.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Events> findByJour(LocalDate jour) {
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Events where jour like :jour");
		myQuery.setParameter("jour", jour);
		List<Events> objets = myQuery.getResultList();
		em.close();
		return objets;
	}
}
