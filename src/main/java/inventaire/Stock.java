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
	
	@OneToMany
	@JoinColumn(name="id_article")
	private List<Article> articles;
	
	@OneToOne
	@JoinColumn(name="id_bar")
	private Bar bar;
	
	public Stock() {}
	
	public Stock(Bar bar, List<Article> stock) {
		this.bar = bar;
		this.articles = stock;
	}
	
	public Stock(Bar bar) {
		this.bar = bar;
	}

	public int getId_stock() {
		return id_stock;
	}

	public void setId_stock(int id_stock) {
		this.id_stock = id_stock;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void addArticle(Article article) {
		this.articles.add(article);
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Stock [id_stock=" + id_stock + ", article=" + articles + ", bar=" + bar + "]";
	}



}
