package org.erp.gescom.domain;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="mode_reglement")
@TypeAlias("cheque") //remplace l'héritage
public class Cheque extends ModeReglement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numero;
	
	private LocalDate dateValidite = null;
	
	private String typeCheque;
	
	

	public Cheque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cheque(String id, String libelleReglement, List<Facture> factures, String numero, LocalDate dateValidite,
			String typeCheque) {
		super(id, libelleReglement, factures);
		this.numero = numero;
		this.dateValidite = dateValidite;
		this.typeCheque = typeCheque;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(LocalDate dateValidite) {
		this.dateValidite = dateValidite;
	}

	public String getTypeCheque() {
		return typeCheque;
	}

	public void setTypeCheque(String typeCheque) {
		this.typeCheque = typeCheque;
	}

	
	
	

}
