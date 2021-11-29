package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOBoisson;
import dao.IDAOCompte;
import dao.IDAOStock;
import dao.jpa.DAOStock;
import dao.jpa.DAOBoisson;
import comptes.Compte;

public class Context {


	//elements liés à NOTRE PROJET//
	private Compte connected;
	private IDAOBoisson daoBoisson = new DAOBoisson();
	private IDAOStock daoStock = new DAOStock();
	private IDAOCompte daoCompte = new DAOCompte();
	/////
	
	
	
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
	//Getters / Setters liés à NOTRE PROJET
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

	public IDAOCarte getDaoStock() {
		return daoStock;
	}

	public void setDaoStock(IDAOCarte daoStock) {
		this.daoStock = daoStock;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	
	///
	
	
	
	
	
}

