package dao.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fonctionnalitees.Events;
import idao.jpa.IDAOEvents;
import util.Context;

public class DAOEvents implements IDAOEvents{
	

	@Override
	public Events findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Events objet = em.find(Events.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Events> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<Events> objets = em.createQuery("from Events").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Events save(Events objet) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		objet=em.merge(objet);

		em.getTransaction().commit();
		em.close();

		return objet;
	}

	@Override
	public void delete(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Events objet = em.find(Events.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Events> findAllByJour(LocalDate jour) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Events where jour = :jour");
		myQuery.setParameter("jour", jour);
		List<Events> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

	@Override
	public List<Events> findAllByEmploye(int id_employe) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Events where id_emp =:id");
		myQuery.setParameter("id", id_employe);
		List<Events> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

}
