package test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import comptes.Admin;
import comptes.Client;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;
import fonctionnalitees.CarteFidelite;
import fonctionnalitees.Intervention;
import fonctionnalitees.StatutIntervention;
import idao.jpa.IDAOBoisson;
import idao.jpa.IDAOEvents;


import idao.jpa.IDAOStock;
import inventaire.Bar;
import inventaire.Boisson;
import inventaire.Stock;
import util.Context;


public class App {
	
	static IDAOBoisson daoB = Context.getInstance().getDaoBoisson();
	static IDAOStock daoS = Context.getInstance().getDaoStock();
	static IDAOEvents daoE = Context.getInstance().getDaoEvents();
	
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

	public static void choixBar() {
		
		List<Bar> bars=Context.getInstance().getDaoBar().findAll();
		System.out.println("Bonjour, la liste des bars est :");
		for(Bar b : bars) {
			System.out.println(b);
		}
		
		int id_bar = saisieInt("Dans quel Bar voulez vous aller ? (numero id)");
		Bar bar = context.getInstance().getDaoBar().findById(id_bar);
		context.setBar(bar); 
		menuPrincipal();
		
		}
	
	
	public static void choixEmploye() {
			
			List<Employe> employes=Context.getInstance().getDaoEmploye().findAll();
			System.out.println("Bonjour, la liste des employes est :");
			for(Employe e: employes) {
				System.out.println(e);
			}
			
			int id_employe = saisieInt("Quel employe êtes-vous ? (numero id)");
			Employe employe = context.getInstance().getDaoEmploye().findById(id_employe);
			context.setEmploye(employe); 
			menuPrincipal();
			
			}
	
	public static void menuPrincipal() {
		
		
		
		System.out.println("Bienvenue dans la taverne!");
		System.out.println("1 - Connexion");
		System.out.println("2 - Inscription");
		System.out.println("3 - Consulter la carte");
		System.out.println("4 - Consulter les évènements à venir");
		System.out.println("5 - Changer de Bar");
		System.out.println("6 - Quitter l'application");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: seConnecter(); break;
		case 2: inscription(); break;
		case 3: consulterCartes(); break;
		case 4: consulterEvenements(StatutIntervention.Acceptée); break;
		case 5: choixBar(); break;
		case 6: System.exit(0); break;
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
		System.out.println("2 - Proposer un évènement");
		System.out.println("3 - Consulter les évènements à venir");
		System.out.println("4 - Se déconnecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: modifierCompte(); break;
		case 2: proposerEvenement(); break;
		case 3: consulterEvenements(StatutIntervention.Acceptée); break;
		case 4: context.setConnected(null); menuPrincipal(); break;
		}
		menuIntervenant();

	}

	private static void proposerEvenement() {
		
		int cout = saisieInt("Combien coutera l'intervention ?");
		int prix = saisieInt("quel sera le prix pour le client ?");
		LocalDateTime debut = LocalDateTime.now();
		LocalDateTime fin = LocalDateTime.now();
		String type = saisieString("Quel type d'intervention ?");
		Intervention intervention = new Intervention(debut, fin, type, cout, prix, (Intervenant) context.getInstance().getConnected(), Context.getInstance().getBar());
		Context.getInstance().getDaoIntervention().save(intervention);
		System.out.println("Votre intervention a été proposée. Nous vous préviendrons si nous acceptions.");
	}

	private static void menuFournisseur() {
		// TODO Auto-generated method stub

	}

	private static void menuAdmin() {
		// TODO Auto-generated method stub
		quiEstCe();
		System.out.println("--------- Menu Admin ---------");
		System.out.println("1 - Modifier un compte");
		System.out.println("2 - Consulter les propositions d'évènement");
		System.out.println("3 - Consulter la carte");
		System.out.println("4 - Consulter les évènements à venir");
		System.out.println("5 - Se déconnecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: modifierCompte(); break;
		case 2: consulterEvenements(StatutIntervention.EnAttente); break;
		case 3: consulterCartes(); break;
		case 4: consulterEvenements(StatutIntervention.Acceptée); break;
		case 5: context.setConnected(null); menuPrincipal(); break;
		}
		menuAdmin();

	}

	private static void menuEmploye() {
		quiEstCe();
		System.out.println("--------- Menu Employ� ---------");
		System.out.println("1 - Acc�der au planning");
		System.out.println("2 - Consulter les evenements à venir");
		System.out.println("3 - Consulter stock");
		System.out.println("4 - Consulter la carte");
		System.out.println("5 - Se d�connecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: consulterHoraires(); break;
		case 2: consulterEvenements(StatutIntervention.Acceptée); break;
		case 3: consulterStock(); break;  //cr�er m�thode consulter stock
		case 4: consulterCartes(); break;
		case 5: context.setConnected(null); menuPrincipal(); break;
		}
		menuAdmin();

	}

	

	private static void menuClient() {
		quiEstCe();
		System.out.println("--------- Menu Client ---------");
		System.out.println("1 - Modifier mes informations");
		System.out.println("2 - Ma carte de fidélité");
		System.out.println("3 - Consulter la carte");
		System.out.println("4 - Consulter les évènements à venir");
		System.out.println("5 - Se d�connecter");

		int choix = saisieInt("Quel est votre choix?");
		switch (choix) {
		case 1: modifierCompte(); break;
		case 2: carteFidelite(); break;
		case 3: consulterCartes(); break;
		case 4: consulterEvenements(StatutIntervention.Acceptée); break;
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
				int idMod = saisieInt("Veuillez saisir l'ID du compte � modifier:");
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
					System.out.println("Compte mis � jour!");
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
		Client c = (Client) Context.getInstance().getConnected();
		CarteFidelite newCarte = new CarteFidelite();
		newCarte=context.getDaoCarteFidelite().save(newCarte);
		c.setCarte(newCarte);
		context.getDaoCompte().save(c);
		System.out.println("Carte de fidelité créée çâ!");
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

	private static void consulterEvenements(StatutIntervention statut) {
		
		List<Intervention> interventions = Context.getInstance().getDaoIntervention().findAllByStatut(statut);
		for(Intervention i : interventions) {
			System.out.println(i);
		}

	}
	
	private static void consulterHoraires() {
		
		
//		daoH.findById(Context.getInstance().getEmploye().getId_employe());
		

	}
	
	

	public static void consulterCartes() {

		if (happyHour()) {

			
			for(Boisson b1 : daoB.findAllByBar(Context.getInstance().getBar().getId_bar())) 
			{
				System.out.println(b1.getNom()+ "prix: " + (b1.getPrixHThh())*1.2);
			}
			
		}

		else {

			for(Boisson b1 : daoB.findAllByBar(Context.getInstance().getBar().getId_bar())) 
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

		choixBar();

	}

}
