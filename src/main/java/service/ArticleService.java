package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ArticleException;
import model.comptes.Fournisseur;
import model.inventaire.Article;
import model.inventaire.TypeArticle;
import repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepo;
	@Autowired
	private FournisseurService fournisseurService;
	
	public List<Article> getAll(){
		return articleRepo.findAll();
	}
	
	public Article getById(Long id) {
		Check.checkLong(id);
		return articleRepo.findById(id).orElseThrow(ArticleException::new);
	}
	
	public List<Article> getAllByFournisseur(Fournisseur fournisseur) {
		return articleRepo.findAllByFournisseur(fournisseur);
	}
	
//	public List<Article> getAllByFournisseur(Long id){
//		return getAllByFournisseur(CompteService.getByFournisseur(id));
//	}
	
	public List<Article> getAllByTypeArticle(String typeProduit){
		if(Arrays.asList(TypeArticle.values()).contains(TypeArticle.valueOf(typeProduit))) {
			return getAllByTypeArticle(TypeArticle.valueOf(typeProduit));
		}
		throw new ArticleException();
	}
	
	public List<Article> getAllByTypeArticle(TypeArticle typeProduit){
		return articleRepo.findAllByTypeProduit(typeProduit);
	}
	
	public void checkArticle(Article article) {
		if (article.getCout()==0 || article.getTypeProduit()==null || article.getVolume()==0) {
			throw new ArticleException();
		}
	}
	
	public Article create(Article article) {
		Check.checkLong(article.getFournisseur().getId());
		checkArticle(article);
		return articleRepo.save(article);
	}
	
	public Article update(Article article) {
		Check.checkLong(article.getId());
		Article articleEnBase = getById(article.getId());
		article.setVersion(articleEnBase.getVersion());
		return articleRepo.save(article);
	}
	

}
