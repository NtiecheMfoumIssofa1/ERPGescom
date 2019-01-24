package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Taxes;
import org.erp.gescom.service.dto.ArticleDTO;
import org.springframework.stereotype.Service;
@Service
public class ArticleMapper {
	
	public ArticleDTO articleToArticleDTO(Article article){
		
		return new ArticleDTO(article);
	}
	
	public List<ArticleDTO> articlesToArticleDTOs(List<Article> articles){
		
		return articles.stream()
				.filter(Objects::nonNull)
				.map(this::articleToArticleDTO)
				.collect(Collectors.toList());
	}
	
	public Article articleDTOToArticle(ArticleDTO articleDTO){
		
		if(articleDTO == null){
			return null;
		}else{
			Article article = new Article();
			
			article.setRefArticle(articleDTO.getRefArticle());
			article.setDateLivraison(articleDTO.getDateLivraison());
			article.setDateMiseAjour(articleDTO.getDateMiseAjour());
			article.setDesignation(articleDTO.getDesignation());
			article.setEtat(articleDTO.isEtat());
			//article.setFamilleArticle(articleDTO.getFamilleArticle());
			//article.setFournisseur(articleDTO.getFournisseur());
			article.setImage(articleDTO.getImage());
			article.setPrixUnitaire(articleDTO.getPrixUnitaire());
			article.setQuantiteArticle(articleDTO.getQuantiteArticle());
			article.setQuantiteSeuil(article.getQuantiteSeuil());
			//article.setStock(articleDTO.getStock());
			Set<Taxes> taxes = this.taxesFromString(articleDTO.getTaxes());
				if( taxes != null){
					article.setTaxes(taxes);
				}
			
			return article;
			
		}
	}
	
	public List<Article> articleDTOsToArticles(List<ArticleDTO> articleDTOs){
		
		return articleDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::articleDTOToArticle)
				.collect(Collectors.toList());
		
	}
	
	public Set<Taxes> taxesFromString(Set<String> doubles){
		return doubles.stream().map(t-> {
			Taxes taxes = new Taxes();
			taxes.setIdTaxe(t);
			return taxes;
		}).collect(Collectors.toSet());
	}

}
