package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Taxes;
import org.springframework.data.annotation.Id;
public class TaxesDTO {
	@Id
	private String idTaxe;
	private double tauxtaxe;
	private List<String> articles;
	private boolean etat;
	
	public TaxesDTO() {
		
	}
	public TaxesDTO(Taxes taxes) {
		this.idTaxe = taxes.getIdTaxe();
		this.tauxtaxe = taxes.getTauxtaxe();
		this.articles = taxes.getArticles().stream()
				.map(Article::getRefArticle)
				.collect(Collectors.toList());
	}
	public String getIdTaxe() {
		return idTaxe;
	}
	public void setIdTaxe(String idTaxe) {
		this.idTaxe = idTaxe;
	}
	public double getTauxtaxe() {
		return tauxtaxe;
	}
	public void setTauxtaxe(double tauxtaxe) {
		this.tauxtaxe = tauxtaxe;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<String> getArticles() {
		return articles;
	}
	public void setArticles(List<String> articles) {
		this.articles = articles;
	}
	
	

}
