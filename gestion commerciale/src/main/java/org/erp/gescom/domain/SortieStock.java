package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document(collection="stock")
@TypeAlias("sortie")
public class SortieStock extends Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Field("date_sortie")
	private Instant dateSortie;
	
	
	

	
	public SortieStock() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SortieStock(String refStock, @NotNull @Size(max = 40) String designationStock, int quantiteStock,
			Set<Article> articles, boolean etat, Instant dateSortie) {
		super(refStock, designationStock, quantiteStock, articles, etat);
		this.dateSortie = dateSortie;
	}





	public Instant getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Instant dateSortie) {
		this.dateSortie = dateSortie;
	}
	

}
