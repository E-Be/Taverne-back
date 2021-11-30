package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import comptes.Compte;
import dao.jpa.DAOAchat;
import dao.jpa.DAOArticle;
import dao.jpa.DAOBar;
import dao.jpa.DAOBoisson;
import dao.jpa.DAOCarteFidelite;
import dao.jpa.DAOCompte;
import dao.jpa.DAOEmploye;
import dao.jpa.DAOEvents;
import dao.jpa.DAOIntervention;
import dao.jpa.DAOLogAlerte;
import dao.jpa.DAOStock;
import dao.jpa.DAOUtilisation;
import idao.jpa.IDAOAchat;
import idao.jpa.IDAOArticle;
import idao.jpa.IDAOBar;
import idao.jpa.IDAOBoisson;
import idao.jpa.IDAOCarteFidelite;
import idao.jpa.IDAOCompte;
import idao.jpa.IDAOEmploye;
import idao.jpa.IDAOEvents;
import idao.jpa.IDAOIntervention;
import idao.jpa.IDAOLogAlerte;
import idao.jpa.IDAOStock;
import idao.jpa.IDAOUtilisation;
import inventaire.Bar;
import comptes.Employe;

public class Context {


	//elements lies a NOTRE PROJET//
	private Compte connected;
	private Bar bar;
	private Employe employe;
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOArticle daoArticle = new DAOArticle();
	private IDAOBar daoBar = new DAOBar();
	private IDAOBoisson daoBoisson = new DAOBoisson();
	private IDAOCarteFidelite daoCarteFidelite = new DAOCarteFidelite();
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOEmploye daoEmploye = new DAOEmploye();
	private IDAOEvents daoEvents = new DAOEvents();
	private IDAOIntervention daoIntervention = new DAOIntervention();
	private IDAOLogAlerte daoLogAlerte = new DAOLogAlerte();
	private IDAOStock daoStock = new DAOStock();
	private IDAOUtilisation daoUtilisation = new DAOUtilisation();

	
	


	/////
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("taverne");
	
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

	
	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
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

	public IDAOStock getDaoStock() {
		return daoStock;
	}

	public void setDaoStock(IDAOStock daoStock) {
		this.daoStock = daoStock;
	}

	public IDAOUtilisation getDaoUtilisation() {
		return daoUtilisation;
	}

	public void setDaoUtilisation(IDAOUtilisation daoUtilisation) {
		this.daoUtilisation = daoUtilisation;
	}

	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}

	public void setDaoAchat(IDAOAchat daoAchat) {
		this.daoAchat = daoAchat;
	}

	public IDAOBar getDaoBar() {
		return daoBar;
	}

	public void setDaoBar(IDAOBar daoBar) {
		this.daoBar = daoBar;
	}

	public IDAOArticle getDaoArticle() {
		return daoArticle;
	}

	public void setDaoArticle(IDAOArticle daoArticle) {
		this.daoArticle = daoArticle;
	}

	public IDAOIntervention getDaoIntervention() {
		return daoIntervention;
	}

	public void setDaoIntervention(IDAOIntervention daoIntervention) {
		this.daoIntervention = daoIntervention;
	}

	public IDAOEvents getDaoEvents() {
		return daoEvents;
	}

	public void setDaoEvents(IDAOEvents daoEvents) {
		this.daoEvents = daoEvents;
	}

	public IDAOCarteFidelite getDaoCarteFidelite() {
		return daoCarteFidelite;
	}

	public void setDaoCarteFidelite(IDAOCarteFidelite daoCarteFidelite) {
		this.daoCarteFidelite = daoCarteFidelite;
	}

	public IDAOEmploye getDaoEmploye() {
		return daoEmploye;
	}

	public void setDaoEmploye(IDAOEmploye daoEmploye) {
		this.daoEmploye = daoEmploye;
	}

	public IDAOLogAlerte getDaoLogAlerte() {
		return daoLogAlerte;
	}

	public void setDaoLogAlerte(IDAOLogAlerte daoLogAlerte) {
		this.daoLogAlerte = daoLogAlerte;
	}
	
	
	

	
	///
	
	
	
	
	
}

