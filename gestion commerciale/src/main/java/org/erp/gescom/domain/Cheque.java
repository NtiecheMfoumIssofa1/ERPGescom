package org.erp.gescom.domain;

import java.io.Serializable;

import java.time.LocalDate;

public class Cheque extends ModeReglement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numero;
	
	private LocalDate dateValidite = null;
	
	private String typeCheque;

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
