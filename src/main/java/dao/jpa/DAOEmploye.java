package dao.jpa;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import idao.jpa.IDAOEmploye;
import model.comptes.Employe;
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

	@Override
	public List<Employe> findAllByHoraire(LocalTime heure) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("Select distinct e from Employe e join e.events where events.debut <= :heure && events.fin >= :heure");
		myQuery.setParameter("heure", heure);
		List<Employe> objets = myQuery.getResultList();
		em.close();
		return objets;
		// TODO Auto-generated method stub
	}
}
