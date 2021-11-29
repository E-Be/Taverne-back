package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCreationBaseJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("taverne");
		EntityManager em = emf.createEntityManager();
		
		/*
		em.getTransaction().begin();
		em.persist(p);
		em.persist(p2);
		
		em.getTransaction().commit();
		*/
		
		
		em.close();
		emf.close();
	}

}
