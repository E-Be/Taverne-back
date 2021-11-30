package inventaire;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import dao.jpa.DAOLogAlerte;
import util.Context;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_stock;
	private double volumeTot;
	private Integer seuil_limite;

	@ManyToMany
	@JoinTable(name = "Articles_de_stock")
	private List<Article> articles;

	@ManyToOne
	@JoinColumn(name="id_bar")
	private Bar bar;

	public Stock() {}

	public Stock(double volumeTot, Integer seuil_limite, List<Article> articles, Bar bar) {
		this.volumeTot = volumeTot;
		this.seuil_limite = seuil_limite;
		this.articles = articles;
		this.bar = bar;
	}

	public int getId_stock() {
		return id_stock;
	}

	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}

	public double getVolumeTot() {
		return volumeTot;
	}

	public void setQte(int qte) {
		this.volumeTot = qte;
	}

	public Integer getSeuil_limite() {
		return seuil_limite;
	}

	public void setSeuil_limite(Integer seuil_limite) {
		this.seuil_limite = seuil_limite;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public void utiliserVolume(double volume) {
		this.volumeTot-=volume;

		try {
			if(this.volumeTot<=seuil_limite) {
				Context.getInstance().getDaoLogAlerte().creerAlerte(this);
			}
		}
		catch(Exception e) {
		}

	}


	public void ajouterVolume(double volume) 
	{
		this.volumeTot+=volume;
	}

	@Override
	public String toString() {
		return "Stock [id_stock=" + id_stock + ", qte=" + volumeTot + ", seuil_limite=" + seuil_limite + ", article="
				+ articles + ", bar=" + bar + "]";
	}



}
