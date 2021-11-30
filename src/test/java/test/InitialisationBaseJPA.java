package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import comptes.Admin;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;
import fonctionnalitees.Events;
import fonctionnalitees.Horaires;
import fonctionnalitees.Intervention;
import inventaire.Article;
import inventaire.Bar;
import inventaire.Stock;
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
		
		Horaires horaire = new Horaires(LocalTime.now(), LocalTime.now(), null);
		horaire = Context.getInstance().getDaoHoraires().save(horaire);
		List<Horaires> horaires = new ArrayList<Horaires>();
		horaires.add(horaire);
		Events event1 = new Events(bar, horaire, null, LocalDate.now(), "C'est un horaire");
		event1=Context.getInstance().getDaoEvents().save(event1);
		List<Events> events = new ArrayList<Events>();
		events.add(event1);
		Compte employe = new Employe("employe","employe","titi","titi", "employe@employe.com", bar, events);
		
		Compte f1 = new Fournisseur ("PELTIER","Pascal", "Metro","Cash","metrcash&carry@metro.com","MetroCash&CarryFrance");
		f1 = Context.getInstance().getDaoCompte().save(f1);
		Compte f2 = new Fournisseur ("MAUGER","Christophe", "Leclerc","Leclerc","Leclerc@leclerc.com","Leclerc");
		f2 = Context.getInstance().getDaoCompte().save(f2);
		Compte f3 = new Fournisseur ("DE-MARCELUS","Guillaume", "Beer","C10","C10_fournisseur@C10.com","C10");
		f3 = Context.getInstance().getDaoCompte().save(f3);
		Compte f4 = new Fournisseur ("GILET","Pascal", "Heineken","Heineken","Beer@Heineken.com","Heineken");
		f4 = Context.getInstance().getDaoCompte().save(f4);
		Article biere = new Article("Biere",12.0,"Biere", 25.0, (Fournisseur)f1);
		biere = Context.getInstance().getDaoArticle().save(biere);
		Article coca =  new Article("Coca",12.0,"Soda", 25.0, (Fournisseur)f2);
		coca = Context.getInstance().getDaoArticle().save(coca);
		Stock biereStock = new Stock(50, 10);
		
		
		
		
	}

}
