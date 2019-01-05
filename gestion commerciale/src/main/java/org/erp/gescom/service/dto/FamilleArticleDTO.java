package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Article;




public class FamilleArticleDTO {
	
	private Long idFamille;
	private String libelleFamille;
	private boolean etat;  
	
	private List<Article> articles;
	public FamilleArticleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilleArticleDTO(String libelleFamille) {
		super();
		this.libelleFamille = libelleFamille;
	}
	public Long getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(Long idFamille) {
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
