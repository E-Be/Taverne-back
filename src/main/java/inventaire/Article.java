package inventaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Article")
public class Article {

	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private int id;
	private String nom;
	private double cout;
	private String type_produit;
	private double volume;
	
	
	public Article(String nom,double cout, String type_produit,double volume){
		
		this.nom=nom;
		this.cout=cout;
		this.type_produit=type_produit;
		this.volume=volume;
		
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", cout=" + cout + ", type_produit=" + type_produit + ", volume="
				+ volume + "]";
	}
	
	
}
