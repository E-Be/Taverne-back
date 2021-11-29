package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fonctionnalitees.CarteFidelite;
import fonctionnalitees.Events;
import idao.jpa.IDAOCarteFidelite;
import util.Context;

public class DAOCarteFidelite implements IDAOCarteFidelite {
	

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public CarteFidelite findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		CarteFidelite objet = em.find(CarteFidelite.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<CarteFidelite> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<CarteFidelite> objets = em.createQuery("from carte_client").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public CarteFidelite save(CarteFidelite objet) {
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
		CarteFidelite objet = em.find(CarteFidelite.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<CarteFidelite> findAllByMinPts(int minPts) {
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Events where nbPoints >= :minPts");
		myQuery.setParameter("minPts", minPts);
		List<CarteFidelite> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

}
