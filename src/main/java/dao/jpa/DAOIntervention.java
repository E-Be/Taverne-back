package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import comptes.Compte;
import comptes.Intervenant;
import fonctionnalitees.Intervention;
import idao.jpa.IDAOIntervention;
import inventaire.Stock;
import util.Context;

public class DAOIntervention implements IDAOIntervention {

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	
	public List<Intervention> findByArtiste (String artiste) {
		
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
		EntityManager em = emf.createEntityManager();
		Intervention objet = em.find(Intervention.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Intervention> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Intervention> objets = em.createQuery("from intervention").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Intervention save(Intervention objet) {
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
		Stock objet = em.find(Stock.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	
	
	
	
}
