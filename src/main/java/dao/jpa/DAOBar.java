package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOBar;
import inventaire.Bar;
import inventaire.Bar;
import util.Context;

public class DAOBar implements IDAOBar{

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Bar findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Bar objet = em.find(Bar.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Bar> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Bar> objets = em.createQuery("from Bar").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Bar save(Bar objet) {
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
		Bar objet = em.find(Bar.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
