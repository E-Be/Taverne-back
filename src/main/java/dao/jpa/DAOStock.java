package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import idao.jpa.IDAOStock;
import inventaire.Stock;
import util.Context;

public class DAOStock implements IDAOStock{


	@Override
	public Stock findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Stock objet = em.find(Stock.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Stock> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		List<Stock> objets = em.createQuery("from Stock").getResultList();
		em.close();
		return objets;

	}

	@Override
	public Stock save(Stock objet) {

		return null;
	}

	@Override
	public void delete(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Stock objet = em.find(Stock.class, id);

		em.getTransaction().begin();

		em.remove(objet);

		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Stock> findAllByBar(int id_bar) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Stock where id_bar = :id");
		myQuery.setParameter("id", id_bar);
		List<Stock> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

	

}

