package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.FamilleArticle;
import org.springframework.data.annotation.Id;




public class FamilleArticleDTO {
	@Id
	private String idFamille;
	
	@Size(max=30)
	private String libelleFamille;
	private boolean etat;  
	
	private List<Article> articles;
	public FamilleArticleDTO() {
		
	}
	public FamilleArticleDTO(FamilleArticle familleArticle) {
		this.idFamille = familleArticle.getIdFamille();
		this.libelleFamille = familleArticle.getLibelleFamille();
	}
	public String getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(String idFamille) {
		this.idFamille = idFamille;
	}
	public String getLibelleFamille() {
		return libelleFamille;
	}
	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	

}
