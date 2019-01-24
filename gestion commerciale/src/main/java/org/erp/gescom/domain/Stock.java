package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//debut annotation heritage
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
	  @JsonSubTypes.Type(value = EntrerStock.class, name = "ENTREE"),
	  @JsonSubTypes.Type(value = SortieStock.class, name = "SORTIE"),
	})
//fin annotation héritage
@Document(collection="stock")
public  class Stock  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Set<Article> articles;
	
	private boolean etat;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Stock(String refStock, @NotNull @Size(max = 40) String designationStock, int quantiteStock,
			Set<Article> articles, boolean etat) {
		super();
		this.refStock = refStock;
		this.designationStock = designationStock;
		this.quantiteStock = quantiteStock;
		this.articles = articles;
		this.etat = etat;
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

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {  
		this.articles = articles;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	
}
