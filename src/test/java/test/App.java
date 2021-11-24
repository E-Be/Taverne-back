package test;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import comptes.Admin;
import comptes.Client;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;
import dao.DAOCarte;
import dao.DAOCompte;
import fonctionnalitees.CarteFidelite;

public class App {

	static Compte connected;

	static DAOCompte daoC = new DAOCompte();
	static DAOCarte daoCarte = new DAOCarte();

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
		connected = daoC.connect(login, password);
		if (connected != null) {
			typeCompte = connected.getClass().getSimpleName(); 
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
		daoC.insert(newClient);
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
		case 4: connected = null; menuPrincipal(); break;
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
		case 5: connected = null; menuPrincipal(); break;
		}
		menuAdmin();

	}

	private static void menuEmploye() {
		// TODO Auto-generated method stub

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
		case 5: connected = null; menuPrincipal(); break;
		}
		menuClient();
	}

	private static void modifierCompte() {
		if (connected instanceof Admin) {
			boolean choix = saisieBoolean("Voulez vous modifier le type d'un compte existant?");
			if (choix) {
				System.out.println("Voici la liste des comptes existants:");
				List<Compte> lCompte = daoC.findAll();
				for (Compte c : lCompte) {
					infoCompte(c);
				}
				int idMod = saisieInt("Veuillez saisir l'ID du compte à modifier:");
				System.out.println("Vous modifiez le compte:");
				Compte modC = daoC.findById(idMod);
				infoCompte(modC);
				String typeCompte = saisieString("Choississez le nouveaux type parmis: Admin, Employe, Fournisseur, Intervenant, Client.");
				switch (typeCompte) {
				case "Client": modC = new Client(modC.getId(), modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail()); break;
				case "Admin": modC = new Admin(modC.getId(), modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail()); break;
				case "Employe": modC = new Employe(modC.getId(), modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail()); break;
				case "Fournisseur": modC = new Fournisseur(modC.getId(), modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail(), null); break;
				case "Intervenant": modC = new Intervenant(modC.getId(), modC.getNom(), modC.getPrenom(), modC.getLogin(), modC.getPassword(), modC.getMail()); break;
				default: modC = null; break;
				}
				if (modC != null) {
					daoC.update(modC);
					System.out.println("Compte mis à jour!");
					System.out.println("------------------");
				}
			}
		}
		
		System.out.println("Voici vos informations: ");
		infoCompte(daoC.findById(connected.getId()));
		connected.setNom(saisieString("Saisissez votre nouveau nom."));
		connected.setPrenom(saisieString("Saisissez votre nouveau prenom."));
		connected.setLogin(saisieString("Saisissez votre nouveau login."));
		connected.setPassword(saisieString("Saisissez votre nouveau password."));
		connected.setMail(saisieString("Saisissez votre nouveau mail."));
		daoC.update(connected);
	}

	private static void carteFidelite() {
		// TODO Auto-generated method stub
		if (((Client)connected).getCarte() == null) {
			creerCarteFidelite();
		} else { 
			
		}
	}
	
	private static void creerCarteFidelite() {
		CarteFidelite newCarte = new CarteFidelite((Client)connected);
		daoCarte.insert(newCarte);
		daoC.update(connected);
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
		// TODO Auto-generated method stub

	}

	private static void consulterCartes() {
		// TODO Auto-generated method stub

	}

	private static void quiEstCe() {
		System.out.println("Vous êtes connecté en tant que: " + connected.getPrenom() + " " + connected.getNom() + ".");
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
