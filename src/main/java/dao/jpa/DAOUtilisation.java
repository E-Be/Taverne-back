package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import idao.jpa.IDAOUtilisation;
import inventaire.Utilisation;
import util.Context;

public class DAOUtilisation implements IDAOUtilisation{

	
	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Utilisation findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Utilisation objet = em.find(Utilisation.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Utilisation> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Utilisation> objets = em.createQuery("from Utilisation").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Utilisation save(Utilisation objet) {
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
		Utilisation objet = em.find(Utilisation.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}
}
