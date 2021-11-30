package dao.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import idao.jpa.IDAOLogAlerte;
import inventaire.LogAlerte;
import inventaire.Stock;
import util.Context;

public class DAOLogAlerte implements IDAOLogAlerte{

	
	@Override
	public LogAlerte findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		LogAlerte objet = em.find(LogAlerte.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<LogAlerte> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<LogAlerte> objets = em.createQuery("from LogAlertes").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public LogAlerte save(LogAlerte objet) {
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
		LogAlerte objet = em.find(LogAlerte.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void creerAlerte(Stock stock) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		LogAlerte alerte = new LogAlerte(stock, LocalDateTime.now());
		
		
		em.getTransaction().begin();

		alerte=em.merge(alerte);

		em.getTransaction().commit();
		em.close();
	}
	
}
