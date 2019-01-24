package org.erp.gescom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Taxes;
import org.erp.gescom.repository.ArticleRepository;
import org.erp.gescom.repository.TaxesRepository;
import org.erp.gescom.service.dto.AgenceDTO;
import org.erp.gescom.service.dto.ArticleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	
	private final Logger log = LoggerFactory.getLogger(ArticleService.class);
	private final ArticleRepository articleRepository;
	private final TaxesRepository taxesRepository;
	
	public ArticleService(ArticleRepository articleRepository, TaxesRepository taxesRepository) {
		this.taxesRepository = taxesRepository;
		this.articleRepository = articleRepository;
	}
	
	//create Article
	
	public Article createArticle(ArticleDTO articleDTO){
		
		Article article = new Article();
		article.setDateLivraison(articleDTO.getDateLivraison());
		article.setDateMiseAjour(articleDTO.getDateMiseAjour());
		article.setDesignation(articleDTO.getDesignation());
		article.setEtat(articleDTO.isEtat());
		article.setImage(articleDTO.getImage());
		article.setPrixUnitaire(articleDTO.getPrixUnitaire());
		article.setQuantiteArticle(articleDTO.getQuantiteArticle());
		article.setQuantiteSeuil(articleDTO.getQuantiteSeuil());
		article.setRefArticle(articleDTO.getRefArticle());
		
			if (articleDTO.getTaxes() != null){
				Set<Taxes> taxes = articleDTO.getTaxes().stream()
								  .map(taxesRepository::findById)
								  .filter(Optional::isPresent)
								  .map(Optional::get)
								  .collect(Collectors.toSet());
				article.setTaxes(taxes);
						
			}
		articleRepository.save(article);
		log.debug("Created Information for Article: {}", article);
		 return article;
		
		 
	}
	
	//update Aricle
	 public Optional<ArticleDTO> updateArticle(ArticleDTO articleDTO){
		 return Optional.of(articleRepository
				 			.findById(articleDTO.getRefArticle()))
				           .filter(Optional::isPresent)
				           .map(Optional::get)
				           .map(article ->{
				        	   article.setDateLivraison(articleDTO.getDateLivraison());
				        	   article.setDateMiseAjour(articleDTO.getDateMiseAjour());
				        	   article.setDesignation(articleDTO.getDesignation());
				        	   article.setEtat(articleDTO.isEtat());
				        	   article.setImage(articleDTO.getImage());
				        	   article.setPrixUnitaire(articleDTO.getPrixUnitaire());
				        	   article.setQuantiteArticle(articleDTO.getQuantiteArticle());
				        	   article.setQuantiteSeuil(articleDTO.getQuantiteSeuil());
				        	   article.setRefArticle(articleDTO.getRefArticle());
				        	   
				        	   Set<Taxes> managedTaxes = article.getTaxes();
				        	   managedTaxes.clear();
				        	   articleDTO.getTaxes().stream()
				        	   			.map(taxesRepository::findById)
				        	   			.filter(Optional::isPresent)
				        	   			.map(Optional::get)
				        	   			.forEach(managedTaxes::add);
				        	   
				        	   articleRepository.save(article);
				        	   log.debug("Changed Information for Article: {}", article);
				        	   return article;
				        	   
				           })
				           .map(ArticleDTO::new);
	 }
	 
	 //delete Article
	 public void deteleArticle(String ref){
		 articleRepository.findById(ref).ifPresent(article ->{
			 articleRepository.delete(article);
			 log.debug("Deleted Article: {}", article);
		 });
	 }
	 
	 //getAll
	 public List<Article> getAllArticle(){
		  return  articleRepository.findAll();
	 }
	 
	 //getById
	 public Optional<Article> getByRef(String ref){
		 return articleRepository.findOneByRef(ref);
	 }
	//getAllByKeyWord
	 public Page<ArticleDTO> getArticleByMc( Pageable pageable){
		 return articleRepository.findAll(pageable).map(ArticleDTO::new);
	 }
	

}
