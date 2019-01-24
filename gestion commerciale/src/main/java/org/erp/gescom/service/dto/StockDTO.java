package org.erp.gescom.service.dto;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Stock;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class StockDTO {
	
	@Id
	private String refStock;
	
	@NotNull
	@Field("designation_stock")
	@Size(max=40)
	private String designationStock;
	
	@NumberFormat
	@Field("quantite_stock")
	private int quantiteStock;
	@JsonIgnore
	@DBRef
	private Set<String> articles;
	
	private boolean etat;
	
	public StockDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StockDTO(Stock stock){
		this.refStock = stock.getRefStock();
		this.designationStock = stock.getDesignationStock();
		this.quantiteStock = stock.getQuantiteStock();
		this.etat  = stock.isEtat();
		this.articles = stock.getArticles().stream()
								.map(Article::getRefArticle)
								.collect(Collectors.toSet());
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

	public Set<String> getArticles() {
		return articles;
	}

	public void setArticles(Set<String> articles) {
		this.articles = articles;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	
	

}
