package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fonctionnalitees.Horaires;
import idao.jpa.IDAOHoraires;
import util.Context;

public class DAOHoraires implements IDAOHoraires{
	
	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Horaires findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Horaires objet = em.find(Horaires.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Horaires> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Horaires> objets = em.createQuery("from Horaires").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Horaires save(Horaires objet) {
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
		Horaires objet = em.find(Horaires.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}
}
