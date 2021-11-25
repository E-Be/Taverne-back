package util;

import dao.IDAOBoisson;
import dao.IDAOCarte;
import dao.IDAOCatalogue;
import dao.IDAOCompte;
import dao.IDAOStock;
import dao.jdbc.DAOBoissonJDBC;
import dao.jdbc.DAOCarteJDBC;
import dao.jdbc.DAOCatalogueJDBC;
import dao.jdbc.DAOCompteJDBC;
import dao.jpa.DAOStock;
import comptes.Compte;

public class Context {


	//elements liés à NOTRE PROJET//
	private Compte connected;
	private IDAOBoisson daoCompte = new DAOBoisson();
	private IDAOCarte daoPlanete = new DAOCarteJDBC();
	private IDAOTrajet daoTrajet = new DAOTrajetJDBC();
	private IDAOVaisseau daoVaisseau = new DAOVaisseauJDBC();
	private IDAOPassager daoPassager = new DAOPassagerJDBC(); 
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

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoC) {
		this.daoCompte = daoC;
	}

	public IDAOPlanete getDaoPlanete() {
		return daoPlanete;
	}

	public void setDaoPlanete(IDAOPlanete daoP) {
		this.daoPlanete = daoP;
	}

	public IDAOTrajet getDaoTrajet() {
		return daoTrajet;
	}

	public void setDaoTrajet(IDAOTrajet daoT) {
		this.daoTrajet = daoT;
	}

	public IDAOVaisseau getDaoVaisseau() {
		return daoVaisseau;
	}

	

	public IDAOPassager getDaoPassager() {
		return daoPassager;
	}

	public void setDaoPassager(DAOPassagerJDBC daoPassager) {
		this.daoPassager = daoPassager;
	}
	///
	
	
	
	
	
}

