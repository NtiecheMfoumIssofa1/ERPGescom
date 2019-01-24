package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.FamilleArticle;
import org.erp.gescom.service.dto.FamilleArticleDTO;
import org.springframework.stereotype.Service;

@Service
public class FamilleArticleMapper {
	
	public FamilleArticleDTO familleToFamilleDTos(FamilleArticle familleArticle){
		return new FamilleArticleDTO(familleArticle);
	}
	
	public List<FamilleArticleDTO> famillesToFamilleDTOs(List<FamilleArticle> familleArticles){
		return familleArticles.stream()
					.filter(Objects::nonNull)
					.map(this::familleToFamilleDTos)
					.collect(Collectors.toList());
	}
	
	public FamilleArticle familleDTOToFamille(FamilleArticleDTO familleArticleDTO){
		if(familleArticleDTO == null){
			return null;
		}else{
			FamilleArticle familleArticle = new FamilleArticle();
			familleArticle.setIdFamille(familleArticleDTO.getIdFamille());
			familleArticle.setLibelleFamille(familleArticleDTO.getLibelleFamille());
			familleArticle.setEtat(familleArticle.isEtat());
			List<Article> articles = this.articleFromStrings(familleArticleDTO.getArticles());
				if(articles != null){
					familleArticle.setArticles(articles);
				}
			return familleArticle;	
			
		}
	}
	
	public List<FamilleArticle> familleDTOsToFamilles(List<FamilleArticleDTO> familleArticlesDTO){
		return familleArticlesDTO.stream()
				.filter(Objects::nonNull)
				.map(this::familleDTOToFamille)
				.collect(Collectors.toList());
				
	}
	
	public List<Article> articleFromStrings(List<String> strings){
		return strings.stream().map(string ->{
			Article article = new Article();
			article.setRefArticle(string);
			return article;
		}).collect(Collectors.toList());
	}

}
