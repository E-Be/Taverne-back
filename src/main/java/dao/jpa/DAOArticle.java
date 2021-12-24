package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import idao.jpa.IDAOArticle;
import model.fonctionnalitees.Events;
import model.inventaire.Article;
import util.Context;

public class DAOArticle implements IDAOArticle {


	@Override
	public Article findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Article objet = em.find(Article.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Article> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<Article> objets = em.createQuery("from Article").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Article save(Article objet) {
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
		Article objet = em.find(Article.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Article> findAllByTypeProduit(String typeProduit) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Article where type_produit like :TypeProduit");
		myQuery.setParameter("TypeProduit", typeProduit);
		List<Article> objets = myQuery.getResultList();
		em.close();
		return objets;
	}

	@Override
	public List<Article> findAllByFournisseur(int id_fournisseur) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query myQuery = em.createQuery("from Article where id_fournisseur = :id");
		myQuery.setParameter("id", id_fournisseur);
		List<Article> objets = myQuery.getResultList();
		em.close();
		return objets;
	}
	
	

}
