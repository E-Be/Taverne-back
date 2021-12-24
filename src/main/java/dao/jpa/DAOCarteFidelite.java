package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import idao.jpa.IDAOCarteFidelite;
import model.fonctionnalitees.CarteFidelite;
import model.fonctionnalitees.Events;
import util.Context;

public class DAOCarteFidelite implements IDAOCarteFidelite {
	

	@Override
	public CarteFidelite findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		CarteFidelite objet = em.find(CarteFidelite.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<CarteFidelite> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<CarteFidelite> objets = em.createQuery("from carte_client").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public CarteFidelite save(CarteFidelite objet) {
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
		CarteFidelite objet = em.find(CarteFidelite.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<CarteFidelite> findAllByMinPts(int minPts) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Events where nbPoints >= :minPts");
		myQuery.setParameter("minPts", minPts);
		List<CarteFidelite> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

}
