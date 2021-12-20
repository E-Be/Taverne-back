package inventaire;

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
	private Integer seuil_limite;

	@ManyToMany
	@JoinTable(name = "Articles_de_stock")
	private Set<Article> articles;

	@ManyToOne
	@JoinColumn(name="id_bar")
	private Bar bar;

	public Stock() {}

	public Stock(double volumeTot, Integer seuil_limite, Set<Article> articles, Bar bar) {
		this.volumeTot = volumeTot;
		this.seuil_limite = seuil_limite;
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

	public Integer getSeuil_limite() {
		return seuil_limite;
	}

	public void setSeuil_limite(Integer seuil_limite) {
		this.seuil_limite = seuil_limite;
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
			if(this.volumeTot<=seuil_limite) {
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
		return "Stock [id_stock=" + idStock + ", qte=" + volumeTot + ", seuil_limite=" + seuil_limite + ", article="
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
