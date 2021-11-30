package test;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;

import comptes.Admin;
import comptes.Client;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;
import inventaire.Boisson;
import inventaire.Bar;
import inventaire.Stock;

import idao.jpa.IDAOBoisson;
import idao.jpa.IDAOStock;

import dao.jpa.DAOBoisson;
import fonctionnalitees.CarteFidelite;
import util.Context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class App {
	
	static IDAOBoisson daoB = Context.getInstance().getDaoBoisson();
	static IDAOStock daoS = Context.getInstance().getDaoStock();
	
	static Context context = Context.getInstance();
	static EntityManagerFactory emf = Context.getInstance().getEmf();
	
	

	public static String saisieString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		String valeur = sc.nextLine();
		return valeur;
	}

	public static int saisieInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int valeur = sc.nextInt();
		return valeur;
	}

	public static double saisieDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		double valeur = sc.nextDouble();
		return valeur;
	}

	public static boolean saisieBoolean(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + " (oui/non)");
		String valeur = sc.nextLine();
		boolean reponse = true;
		if (valeur.equalsIgnoreCase("oui")) {
			reponse = true;
		} else if (valeur.equalsIgnoreCase("non")) {
			reponse = false;
		} else {
			reponse = saisieBoolean(msg);
		}

		return reponse;

	}

	public static void menuPrincipal() {
		System.out.println("Bienvenue dans la taverne!");
		System.out.println("1 - Connexion");
		System.out.println("2 - Inscription");
		System.out.println("3 - Consulter la carte");
		System.out.println("4 - Consulter les événements à venir");
		System.out.println("5 - Quitter l'application");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: seConnecter(); break;
		case 2: inscription(); break;
		case 3: consulterCartes(); break;
		case 4: consulterEvenements(); break;
		case 5: System.exit(0); break;
		}
		menuPrincipal();
	}

	private static void seConnecter() {
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String typeCompte;
		context.setConnected(context.getDaoCompte().connect(login, password));
		if (context.getConnected() != null) {
			typeCompte = context.getConnected().getClass().getSimpleName(); 
		} else {typeCompte = "Null"; }

		switch (typeCompte.toString()) {
		case "Client": menuClient(); break;
		case "Employe": menuEmploye(); break;
		case "Admin": menuAdmin(); break;
		case "Fournisseur": menuFournisseur(); break;
		case "Intervenant": menuIntervenant(); break;
		default: System.out.println("Identifiants invalides"); break;
		}
		menuPrincipal();
	}

	private static void inscription() {
		String nom = saisieString("Veuillez saisir votre nom.");
		String prenom = saisieString("Veuillez saisir votre prenom.");
		String login = saisieString("Veuillez saisir votre login.");
		String password = saisieString("Veuillez saisir votre mot de passe.");
		String mail = saisieString("Veuillez saisir votre adresse email.");
		Client newClient = new Client(nom,prenom,login,password,mail);
		context.getDaoCompte().save(newClient);
		seConnecter();

	}

	private static void menuIntervenant() {
		// TODO Auto-generated method stub
		quiEstCe();
		System.out.println("--------- Menu Intervennant ---------");
		System.out.println("1 - Modifier mes informations");
		System.out.println("2 - Proposer un événement");
		System.out.println("3 - Consulter les événements à venir");
		System.out.println("4 - Se déconnecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: modifierCompte(); break;
		case 2: proposerEvenement(); break;
		case 3: consulterEvenements(); break;
		case 4: context.setConnected(null); menuPrincipal(); break;
		}
		menuIntervenant();

	}

	private static void proposerEvenement() {
		// TODO Auto-generated method stub
		
	}

	private static void menuFournisseur() {
		// TODO Auto-generated method stub

	}

	private static void menuAdmin() {
		// TODO Auto-generated method stub
		quiEstCe();
		System.out.println("--------- Menu Admin ---------");
		System.out.println("1 - Modifier un compte");
		System.out.println("2 - Consulter les propositions d'événement");
		System.out.println("3 - Consulter la carte");
		System.out.println("4 - Consulter les événements à venir");
		System.out.println("5 - Se déconnecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: modifierCompte(); break;
		case 2: carteFidelite(); break;
		case 3: consulterCartes(); break;
		case 4: consulterEvenements(); break;
		case 5: context.setConnected(null); menuPrincipal(); break;
		}
		menuAdmin();

	}

	private static void menuEmploye() {
		quiEstCe();
		System.out.println("--------- Menu Employé ---------");
		System.out.println("1 - Accéder au planning");
		System.out.println("2 - Consulter stock");
		System.out.println("3 - Consulter la carte");
		System.out.println("5 - Se déconnecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: consulterEvenements(); break;
		case 2: consulterStock(); break;  //créer méthode consulter stock
		case 3: consulterCartes(); break;
		case 4: context.setConnected(null); menuPrincipal(); break;
		}
		menuAdmin();

	}

	

	private static void menuClient() {
		quiEstCe();
		System.out.println("--------- Menu Client ---------");
		System.out.println("1 - Modifier mes informations");
		System.out.println("2 - Ma carte de fidélité");
		System.out.println("3 - Consulter la carte");
		System.out.println("4 - Consulter les événements à venir");
		System.out.println("5 - Se déconnecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: modifierCompte(); break;
		case 2: carteFidelite(); break;
		case 3: consulterCartes(); break;
		case 4: consulterEvenements(); break;
		case 5: context.setConnected(null); menuPrincipal(); break;
		}
		menuClient();
	}

	private static void modifierCompte() {
		if (context.getConnected() instanceof Admin) {
			boolean choix = saisieBoolean("Voulez vous modifier le type d'un compte existant?");
			if (choix) {
				System.out.println("Voici la liste des comptes existants:");
				List<Compte> lCompte = context.getDaoCompte().findAll();
				for (Compte c : lCompte) {
					infoCompte(c);
				}
				int idMod = saisieInt("Veuillez saisir l'ID du compte à modifier:");
				System.out.println("Vous modifiez le compte:");
				Compte modC = context.getDaoCompte().findById(idMod);
				infoCompte(modC);
				String typeCompte = saisieString("Choississez le nouveaux type parmis: Admin, Employe, Fournisseur, Intervenant, Client.");
				switch (typeCompte) {
				case "Client": modC = new Client(modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail()); break;
				case "Admin": modC = new Admin(modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail()); break;
				case "Employe": modC = new Employe(modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail(), null, null); break;
				case "Fournisseur": modC = new Fournisseur(modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail(), null); break;
				case "Intervenant": modC = new Intervenant(modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail(), null, null, null); break;
				default: modC = null; break;
				}
				if (modC != null) {
					modC.setId(idMod);
					context.getDaoCompte().save(modC);
					System.out.println("Compte mis à jour!");
					System.out.println("------------------");
				}
			}
		}
		
		System.out.println("Voici vos informations: ");
		infoCompte(context.getDaoCompte().findById(context.getConnected().getId()));
		context.getConnected().setNom(saisieString("Saisissez votre nouveau nom."));
		context.getConnected().setPrenom(saisieString("Saisissez votre nouveau prenom."));
		context.getConnected().setLogin(saisieString("Saisissez votre nouveau login."));
		context.getConnected().setPassword(saisieString("Saisissez votre nouveau password."));
		context.getConnected().setMail(saisieString("Saisissez votre nouveau mail."));
		context.getDaoCompte().save(context.getConnected());
	}

	private static void carteFidelite() {
		// TODO Auto-generated method stub
		if (((Client)context.getConnected()).getCarte() == null) {
			creerCarteFidelite();
		} else { 
			
		}
	}
	
	private static void creerCarteFidelite() {
		CarteFidelite newCarte = new CarteFidelite((Client)context.getConnected());
		context.getDaoCarteFidelite().save(newCarte);
		context.getDaoCompte().save(context.getConnected());
		System.out.println("Carte de fidélité créée!");
		carteFidelite();
	}

	private static void infoCompte(Compte c) {
		if (c instanceof Fournisseur || (c instanceof Intervenant && ((Intervenant)c).getEntreprise() != null) ) {
			System.out.println("Compte " + c.getClass().getSimpleName() + ", ID: " + c.getId() + " appartenant à " 
					+ c.getPrenom() + " " + c.getNom() + " (" + c.getMail() + ").\nEntreprise: " + ((Fournisseur)c).getEntreprise() + "." );
		} else {
			System.out.println("Compte " + c.getClass().getSimpleName() + ", ID: " + c.getId() + " appartenant à " 
					+ c.getPrenom() + " " + c.getNom() + " (" + c.getMail() + ").");	
		}
	}

	private static void consulterEvenements() {
		//Consultation des evenements liés au bar
		
		

	}

	public static void consulterCartes() {

		if (happyHour()) {

			
			for(Boisson b1 : daoB.findAllByBar(Bar.getId_bar())) 
			{
				System.out.println(b1.getNom()+ "prix: " + (b1.getPrixHThh())*1.2);
			}
			
		}

		else {

			for(Boisson b1 : daoB.findAllByBar(Bar.getId_bar())) 
			{
				System.out.println(b1.getNom()+ "prix: " + (b1.getPrixHT())*1.2);
			}
		}
		



	}
	
	private static void consulterStock() {
		
		for(Stock s : daoS.findAll()) 
		{
			System.out.println("Article:" +s.getArticles()+ "Volume total: " +s.getVolumeTot()+ "Seuil  limite: " + s.getSeuil_limite());
		}
	}
	
	

	private static void quiEstCe() {
		System.out.println("Vous êtes connecté en tant que: " + context.getConnected().getPrenom() + " " + context.getConnected().getNom() + ".");
	}
	
	private static boolean happyHour() {
		if (LocalTime.now().isAfter(LocalTime.parse("17:00:00")) && LocalTime.now().isBefore(LocalTime.parse("21:00:00"))) {
			return true;
		} else {return false;}	
	}

	public static void main(String[] args) {

		menuPrincipal();

	}

}
