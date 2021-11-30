package dao.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import comptes.Client;
import fonctionnalitees.Achat;
import idao.jpa.IDAOBar;
import inventaire.Article;
import inventaire.Bar;
import inventaire.Boisson;
import inventaire.Stock;
import inventaire.Utilisation;
import util.Context;

public class DAOBar implements IDAOBar{


	@Override
	public Bar findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Bar objet = em.find(Bar.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Bar> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		List<Bar> objets = em.createQuery("from Bar").getResultList();
		em.close();
		return objets;

	}

	@Override
	public Bar save(Bar objet) {
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
		Bar objet = em.find(Bar.class, id);

		em.getTransaction().begin();

		em.remove(objet);

		em.getTransaction().commit();
		em.close();

	}
	@Override
	public Stock approvisioner(Article article,Bar bar) {

		//Find un stock concernant cet article (idée list art : on retrouve dans quel stock il appartient à la liste d'article via son type)
		//y ajouter le volume acheté
		//save ce stock

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT s from Stock s join s.articles a where a.type_produit=:lib and s.bar.id_bar=:id");
		q.setParameter("lib", article.getType_produit());
		q.setParameter("id", bar.getId_bar());

		Stock stock;
		List<Article> articles=new ArrayList();;
		try
		{
			stock= (Stock) q.getSingleResult();
			stock.getArticles().add(article);
			stock.ajouterVolume(article.getVolume());
		}
		catch(Exception e) 
		{
			articles.add(article);
			stock = new Stock(article.getVolume(),null,articles,bar);
		}

		em.getTransaction().begin();
		stock=	em.merge(stock);
		em.getTransaction().commit();
		em.close();

		return stock;
	}

	public Achat achatBoisson(Client client, Boisson boisson) {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Achat achat = new Achat(LocalDate.now(),boisson,client);
		
		em.getTransaction().begin();
		//Recup les ingredients de la boisson, pour chaque ingredient, baisser le stock
		List<Utilisation> utils = boisson.getUtilisations();
		for(Utilisation u : utils)
		{
			double volumeUtilise = u.getVolume();
			Stock stock = u.getIngredient();
			stock.utiliserVolume(volumeUtilise);
			stock = em.merge(stock);
		}
		achat=em.merge(achat);

		em.getTransaction().commit();
		em.close();
		return achat;

	}


}
