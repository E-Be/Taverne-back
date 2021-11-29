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
	
	
	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Employe findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Employe objet = em.find(Employe.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Employe> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Employe> objets = em.createQuery("from Employe").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Employe save(Employe objet) {
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
		Employe objet = em.find(Employe.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Employe> findAllByBar(int id_bar) {
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Employe where id_bar like :id");
		myQuery.setParameter("id", id_bar);
		List<Employe> objets = myQuery.getResultList();
		em.close();
		return objets;
	}
}
