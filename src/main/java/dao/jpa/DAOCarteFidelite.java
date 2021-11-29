package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fonctionnalitees.CarteFidelite;
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

}
