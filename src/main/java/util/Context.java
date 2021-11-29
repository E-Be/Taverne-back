package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.jpa.DAOStock;
import idao.jpa.IDAOBoisson;
import idao.jpa.IDAOCompte;
import idao.jpa.IDAOStock;
import idao.jpa.IDAOUtilisation;
import dao.jpa.DAOBoisson;
import dao.jpa.DAOCompte;
import dao.jpa.DAOUtilisation;
import comptes.Compte;

public class Context {


	//elements li�s � NOTRE PROJET//
	private Compte connected;
	private IDAOBoisson daoBoisson = new DAOBoisson();
	private IDAOStock daoStock = new DAOStock();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOUtilisation daoUtilisation = new DAOUtilisation();
	/////
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetJpa");
	
	private static Context singleton=null;

	private Context() {}
	
	//getInstance est la methode permettant de recuper l'objet unique dans l'appi (singleton) 
	public static Context getInstance() 
	{
		if(singleton==null) 
		{
			singleton=new Context();
		}
		return singleton;
	}
	
	
	///
	//Getters / Setters li�s � NOTRE PROJET
	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}

	public IDAOBoisson getDaoBoisson() {
		return daoBoisson;
	}

	public void setDaoBoisson(IDAOBoisson daoBoisson) {
		this.daoBoisson = daoBoisson;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	

	
	///
	
	
	
	
	
}

