package inventaire;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_stock;
	private int qte;
	private int seuil_limite;
	
	@OneToMany
	@JoinColumn(name="id_article")
	private List<Article> article;
	
	@OneToOne
	@JoinColumn(name="id_bar")
	private Bar bar;
	
	public Stock() {}
	
	public Stock(int qte, int seuil_limite) {
		this.qte = qte;
		this.seuil_limite=seuil_limite;
	}

	public int getId_stock() {
		return id_stock;
	}

	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getSeuil_limite() {
		return seuil_limite;
	}

	public void setSeuil_limite(int seuil_limite) {
		this.seuil_limite = seuil_limite;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void addArticle(Article article) {
		this.article.add(article);
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Stock [id_stock=" + id_stock + ", qte=" + qte + ", seuil_limite=" + seuil_limite + ", article="
				+ article + ", bar=" + bar + "]";
	}



}
