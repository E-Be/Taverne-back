package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fonctionnalitees.Intervention;
import fonctionnalitees.StatutIntervention;
import idao.jpa.IDAOIntervention;
import inventaire.Bar;
import inventaire.Stock;
import util.Context;

public class DAOIntervention implements IDAOIntervention {

	
	public List<Intervention> findByArtiste (String artiste) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		
		List<Intervention> interventions = new ArrayList<Intervention>();

		Query query = em.createQuery("from Compte c where c.Intervenant=:artiste");
		query.setParameter("artiste", artiste);
		
		try 
		{
			interventions = (List<Intervention>) query.getResultList();
		}
		catch(Exception e) {e.printStackTrace();}
		em.close();
		return interventions;
		}
	
	
	
	
	@Override
	public Intervention findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Intervention objet = em.find(Intervention.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Intervention> findAll() {
		EntityManagerFactory emf = Context.getInstance().getEmf();

		EntityManager em = emf.createEntityManager();
	
		List<Intervention> objets = em.createQuery("from intervention").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Intervention save(Intervention objet) {
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
		Stock objet = em.find(Stock.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}




	@Override
	public List<Intervention> findAllByStatutAndBar(StatutIntervention statut, Bar bar){
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Intervention where statut like :statut and id_bar =:id");
		myQuery.setParameter("statut", statut);
		myQuery.setParameter("id", bar.getId_bar());
		List<Intervention> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

	
	
	
	
}
