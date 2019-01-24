package org.erp.gescom.domain;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document(collection="mode_reglement")
@TypeAlias("livraison")
public class Livraison extends ModeReglement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LocalDate dateLivraison = null;
	
	private String address;
	
	
	
	

	

	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	public Livraison(String id, String libelleReglement, List<Facture> factures, LocalDate dateLivraison,
			String address) {
		super(id, libelleReglement, factures);
		this.dateLivraison = dateLivraison;
		this.address = address;
	}





	public LocalDate getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(LocalDate dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	

}
