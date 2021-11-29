package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fonctionnalitees.Achat;
import idao.jpa.IDAOAchat;
import inventaire.Utilisation;
import fonctionnalitees.Achat;
import util.Context;

public class DAOAchat implements IDAOAchat {
	
	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Achat findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Achat objet = em.find(Achat.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Achat> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Achat> objets = em.createQuery("from Achat").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Achat save(Achat objet) {
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
		Achat objet = em.find(Achat.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}
	
	@Override
	public List<Achat> findAllByClient(int id) {
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Achat where client = :id");
		myQuery.setParameter("id", id);
		List<Achat> objets = myQuery.getResultList();
		em.close();
		return null;
	}

}
