package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;

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
			//article.setTaxes(articleDTO.getTaxes());
			article.setTva(articleDTO.getTva());
			
			return article;
			
		}
	}
	
	public List<Article> articleDTOsToArticles(List<ArticleDTO> articleDTOs){
		
		return articleDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::articleDTOToArticle)
				.collect(Collectors.toList());
		
	}

}
