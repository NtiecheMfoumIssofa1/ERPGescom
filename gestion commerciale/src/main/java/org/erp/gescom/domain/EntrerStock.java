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
@TypeAlias("entree")
public class EntrerStock extends Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Field("date_entree")
	private Instant dateEntree= null;
	
	


	public EntrerStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public EntrerStock(String refStock, @NotNull @Size(max = 40) String designationStock, int quantiteStock,
			Set<Article> articles, boolean etat, Instant dateEntree) {
		super(refStock, designationStock, quantiteStock, articles, etat);
		this.dateEntree = dateEntree;
	}




	public Instant getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Instant dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	

	

	
	
	
	

}
