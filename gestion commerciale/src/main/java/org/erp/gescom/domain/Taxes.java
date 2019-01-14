package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="taxes")
public class Taxes  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idTaxe;
	
	@NumberFormat
	@Field("taux_tva")
	private double tauxtaxe;
	@JsonIgnore
	private List<Article> articles;
	
	private boolean etat;
	
	/*public Taxes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taxes(double tauxtaxe) {
		super();
		this.tauxtaxe = tauxtaxe;
	}*/
	
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
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Taxes t = (Taxes) o;
		return !(t.getIdTaxe() == null || getIdTaxe() == null) && Objects.equals(getIdTaxe(),t.getIdTaxe());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdTaxe());
    }
	@Override
	public String toString() {
		return "Taxes [idTaxe=" + idTaxe + ", tauxtaxe=" + tauxtaxe + ", articles=" + articles + ", etat=" + etat + "]";
	}

}
