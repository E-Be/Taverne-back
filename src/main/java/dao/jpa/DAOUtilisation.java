package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fonctionnalitees.Achat;
import idao.jpa.IDAOUtilisation;
import inventaire.Boisson;
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
	
	@Override
	public List<Utilisation> findAllByBoisson(int id) {
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Utilisation where boisson = :id");
		myQuery.setParameter("id", id);
		List<Utilisation> objets = myQuery.getResultList();
		em.close();
		return objets;
	}
	
	
}
