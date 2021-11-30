package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import comptes.Admin;
import comptes.Client;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;
import fonctionnalitees.Achat;
import fonctionnalitees.CarteFidelite;
import fonctionnalitees.Events;
import fonctionnalitees.Intervention;
import inventaire.Alcool;
import inventaire.Article;
import inventaire.Bar;
import inventaire.Boisson;
import inventaire.Soft;
import inventaire.Stock;
import inventaire.TypeArticle;
import inventaire.Utilisation;
import util.Context;

public class InitialisationBaseJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Intervention> interventions = new ArrayList<Intervention>();
		Bar bar = new Bar("Le Bar", null, null, null, null);
		bar=Context.getInstance().getDaoBar().save(bar);
		
		Intervenant i1 = new Intervenant ("OLICARD", "Fabien", "Master", "Mentaliste", "fabien@olicard.com","Fabien_OLICARD", "mentalism&Co",null);
		
		Intervenant i2 = new Intervenant ("ABID", "Jordan", "Abid", "Jordan", "jordanabid@gmail.com","Hypnotiseur/Mentaliste/Magicien", "Auto-entrepreneur",null);	
		Compte i3 = new Intervenant ("Salut","Hello","Wazaa","Yo","Atchoum","Bingo","Ciao", interventions);
		Context.getInstance().getDaoCompte().save(i1);
		Context.getInstance().getDaoCompte().save(i2);
		i3= Context.getInstance().getDaoCompte().save(i3);
		
		Intervention inter1 = new Intervention (LocalDateTime.now(), LocalDateTime.now(), "barmaid", 250, 105, (Intervenant) i3, bar);
		interventions.add(inter1);
		Context.getInstance().getDaoIntervention().save(inter1);
		
		Compte admin = new Admin("admin", "admin", "root", "root", "admin@mail.com");
		Context.getInstance().getDaoCompte().save(admin);
		
		Compte employe = new Employe("employe","employe","titi","titi", "employe@employe.com", bar, null);
		
		
		Events event1 = new Events(bar, null,LocalDate.now(),LocalTime.now(),LocalTime.now(),"remarque");
		List<Events> events = new ArrayList<Events>();
		events.add(event1);
		employe = Context.getInstance().getDaoCompte().save(employe);
		
		((Employe) employe).setEvents(events);
		event1.setEmp((Employe)employe);
		event1=Context.getInstance().getDaoEvents().save(event1);
		
		Compte f1 = new Fournisseur ("PELTIER","Pascal", "Metro","Cash","metrcash&carry@metro.com","MetroCash&CarryFrance");
		f1 = Context.getInstance().getDaoCompte().save(f1);
		Compte f2 = new Fournisseur ("MAUGER","Christophe", "Leclerc","Leclerc","Leclerc@leclerc.com","Leclerc");
		f2 = Context.getInstance().getDaoCompte().save(f2);
		Compte f3 = new Fournisseur ("DE-MARCELUS","Guillaume", "Beer","C10","C10_fournisseur@C10.com","C10");
		f3 = Context.getInstance().getDaoCompte().save(f3);
		Compte f4 = new Fournisseur ("GILET","Pascal", "Heineken","Heineken","Beer@Heineken.com","Heineken");
		f4 = Context.getInstance().getDaoCompte().save(f4);
		Article biere = new Article("Biere",12.0,TypeArticle.Biere, 25.0, (Fournisseur)f1);
		biere = Context.getInstance().getDaoArticle().save(biere);
		Article coca =  new Article("Coca",12.0,TypeArticle.Coca, 25.0, (Fournisseur)f2);
		coca = Context.getInstance().getDaoArticle().save(coca);
		
		List<Article> bieres = new ArrayList<Article>();
		bieres.add(biere);
		
		List<Article> cocas = new ArrayList<Article>();
		cocas.add(coca);
		
		
		//Stock biereStock = new Stock(50, 10, bieres, bar);
		//biereStock = Context.getInstance().getDaoStock().save(biereStock);
		
		//Stock cocaStock = new Stock(50, 10, cocas, bar);
		//cocaStock = Context.getInstance().getDaoStock().save(cocaStock);
		
		Stock cocaStock=Context.getInstance().getDaoBar().approvisioner(coca, bar);
		cocaStock=Context.getInstance().getDaoBar().approvisioner(coca, bar);
		Stock biereStock=Context.getInstance().getDaoBar().approvisioner(biere, bar);
		
		Boisson demiBiere = new Alcool("Demi de Biere", 5, 5, bar,null);
		demiBiere = Context.getInstance().getDaoBoisson().save(demiBiere);
		
		Utilisation biere25 = new Utilisation (0.25, biereStock, demiBiere);
		biere25 = Context.getInstance().getDaoUtilisation().save(biere25);
		List<Utilisation> recetteBiere = new ArrayList<Utilisation>();
		recetteBiere.add(biere25);
		demiBiere.setUtilisations(recetteBiere);
		
		Boisson bouteilleCoca = new Soft("Bouteille de coca", 4,4,bar,null);
		bouteilleCoca = Context.getInstance().getDaoBoisson().save(bouteilleCoca);
		
		Utilisation coca33 = new Utilisation (0.33, cocaStock, bouteilleCoca);
		coca33 = Context.getInstance().getDaoUtilisation().save(coca33);
		
		List<Utilisation> recetteCoca = new ArrayList<Utilisation>();
		recetteCoca.add(coca33);
		bouteilleCoca.setUtilisations(recetteCoca);
		
		CarteFidelite carteBob = new CarteFidelite(0);
		carteBob = Context.getInstance().getDaoCarteFidelite().save(carteBob);
		
		Compte client = new Client("Bob", "Dylan", "toto", "toto", "bobdylan@mail.com");
		((Client)client).setCarte(carteBob);
		client = Context.getInstance().getDaoCompte().save(client);
		
		Achat achatClientCoca = Context.getInstance().getDaoBar().achatBoisson((Client) client, bouteilleCoca);
		Achat achatClientBiere = Context.getInstance().getDaoBar().achatBoisson((Client) client, demiBiere);
		
		
		((Client)client).setCarte(carteBob);
		client = Context.getInstance().getDaoCompte().save(client);
		
		
		/*
		Achat achat = new Achat(LocalDate.now(), bouteilleCoca, (Client) client);
		Context.getInstance().getDaoAchat().save(achat);
		*/
		
	}

}
