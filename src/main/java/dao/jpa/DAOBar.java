package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import idao.jpa.IDAOBar;
import inventaire.Bar;
import inventaire.Bar;
import util.Context;

public class DAOBar implements IDAOBar{


	@Override
	public Bar findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Bar objet = em.find(Bar.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Bar> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<Bar> objets = em.createQuery("from Bar").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Bar save(Bar objet) {
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
		Bar objet = em.find(Bar.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
