package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOBoisson;
import inventaire.Boisson;
import util.Context;

public class DAOStock implements IDAOStock{

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Stock findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Stock objet = em.find(Stock.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Stock> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Stock> objets = em.createQuery("from Stock").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Stock save(Stock objet) {
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
		Stock objet = em.find(Stock.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}

