package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.SignStyle;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Article;

public abstract class StockDTO {
	private Long refStock;
	private String designationStock;
	private int quantiteStock;
	private List<Article> articles;
	private boolean etat;
	public StockDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockDTO(String designationStock, int quantiteStock) {
		super();
		this.designationStock = designationStock;
		this.quantiteStock = quantiteStock;
	}
	public Long getRefStock() {
		return refStock;
	}
	public void setRefStock(Long refStock) {
		this.refStock = refStock;
	}
	public String getDesignationStock() {
		return designationStock;
	}
	public void setDesignationStock(String designationStock) {
		this.designationStock = designationStock;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	

}
