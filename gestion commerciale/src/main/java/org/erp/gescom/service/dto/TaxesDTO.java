package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Taxes;
import org.springframework.data.annotation.Id;
public class TaxesDTO {
	@Id
	private String idTaxe;
	private double tauxtaxe;
	private List<Article> articles;
	private boolean etat;
	
	public TaxesDTO() {
		
	}
	public TaxesDTO(Taxes taxes) {
		this.idTaxe = taxes.getIdTaxe();
		this.tauxtaxe = taxes.getTauxtaxe();
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
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	

}
