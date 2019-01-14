package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.SignStyle;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Stock;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.NumberFormat;

public abstract class StockDTO {
	
	@Id
	private String refStock;
	@Size(max=50)
	private String designationStock;
	@NumberFormat
	private int quantiteStock;
	private List<Article> articles;
	private boolean etat;
	public StockDTO() {
		
	}
	public StockDTO(Stock stock) {
		this.refStock = stock.getRefStock();
		this.designationStock = stock.getDesignationStock();
		this.quantiteStock = stock.getQuantiteStock();
	}
	public String getRefStock() {
		return refStock;
	}
	public void setRefStock(String refStock) {
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
