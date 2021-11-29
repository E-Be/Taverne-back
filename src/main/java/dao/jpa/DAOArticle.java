package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import idao.jpa.IDAOArticle;
import inventaire.Article;
import inventaire.Article;
import util.Context;

public class DAOArticle implements IDAOArticle {

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Article findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Article objet = em.find(Article.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Article> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Article> objets = em.createQuery("from Article").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Article save(Article objet) {
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
		Article objet = em.find(Article.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
