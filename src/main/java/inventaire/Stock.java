package inventaire;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_stock;
	private double volumeTot;
	private int seuil_limite;
	
	@ManyToOne
	@JoinColumn(name="id_article")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="id_bar")
	private Bar bar;
	
	public Stock() {}

	public Stock(int qte, int seuil_limite, Article article, Bar bar) {
		super();
		this.volumeTot = qte;
		this.seuil_limite = seuil_limite;
		this.article = article;
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

	public int getSeuil_limite() {
		return seuil_limite;
	}

	public void setSeuil_limite(int seuil_limite) {
		this.seuil_limite = seuil_limite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	public void utiliserVolume(double volume) 
	{
		this.volumeTot-=volume;
		if(this.volumeTot<=seuil_limite) 
		{
			System.out.println("ATTENTION ....");
		}
	}

	@Override
	public String toString() {
		return "Stock [id_stock=" + id_stock + ", qte=" + volumeTot + ", seuil_limite=" + seuil_limite + ", article="
				+ article + ", bar=" + bar + "]";
	}



}
