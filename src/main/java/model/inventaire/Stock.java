package model.inventaire;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_stock")
	private Long idStock;
	private double volumeTot;
	@Column(name = "seuil_limite")
	private Integer seuilLimite;

	@ManyToMany
	@JoinTable(name = "Articles_de_stock")
	private Set<Article> articles;

	@ManyToOne
	@JoinColumn(name="id_bar")
	private Bar bar;

	public Stock() {}

	public Stock(double volumeTot, Integer seuilLimite, Set<Article> articles, Bar bar) {
		this.volumeTot = volumeTot;
		this.seuilLimite = seuilLimite;
		this.articles = articles;
		this.bar = bar;
	}

	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long id_stock) {
		this.idStock = id_stock;
	}

	public double getVolumeTot() {
		return volumeTot;
	}

	public void setVolumeTot(double volumeTot) {
		this.volumeTot = volumeTot;
	}

	public Integer getseuilLimite() {
		return seuilLimite;
	}

	public void setseuilLimite(Integer seuilLimite) {
		this.seuilLimite = seuilLimite;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
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
			if(this.volumeTot<=seuilLimite) {
				//Context.getInstance().getDaoLogAlerte().creerAlerte(this);
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
		return "Stock [id_stock=" + idStock + ", qte=" + volumeTot + ", seuilLimite=" + seuilLimite + ", article="
				+ articles + ", bar=" + bar + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(idStock, other.idStock);
	}



}
