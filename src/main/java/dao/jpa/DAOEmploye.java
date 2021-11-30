package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import comptes.Employe;
import fonctionnalitees.Events;
import idao.jpa.IDAOEmploye;
import util.Context;

public class DAOEmploye implements IDAOEmploye{
	
	

	@Override
	public Employe findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Employe objet = em.find(Employe.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Employe> findAll() {
		EntityManagerFactory emf = Context.getInstance().getEmf();

		EntityManager em = emf.createEntityManager();
	
		List<Employe> objets = em.createQuery("from Employe").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Employe save(Employe objet) {
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
		Employe objet = em.find(Employe.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Employe> findAllByBar(int id_bar) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Employe where id_bar = :id");
		myQuery.setParameter("id", id_bar);
		List<Employe> objets = myQuery.getResultList();
		em.close();
		return objets;
	}
}
