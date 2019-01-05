package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;
@Document(collection="stock")
public abstract class Stock extends AbstractAuditingEntity implements Serializable{
	
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
	
	private List<Article> articles;
	
	private boolean etat;
	/*public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String designationStock, int quantiteStock) {
		super();
		this.designationStock = designationStock;
		this.quantiteStock = quantiteStock;
	}*/
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
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Stock s = (Stock) o;
		return !(s.getRefStock() == null || getRefStock() == null) && Objects.equals(getRefStock(),s.getRefStock());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getRefStock());
    }
	@Override
	public String toString() {
		return "Stock [refStock=" + refStock + ", designationStock=" + designationStock + ", quantiteStock="
				+ quantiteStock + ", articles=" + articles + ", etat=" + etat + "]";
	}
	
	
}
