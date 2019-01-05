package org.erp.gescom.domain;

import java.io.Serializable;

import java.time.LocalDate;

public class OrangeMoney extends ModeReglement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String telephone;
	
	private LocalDate datePaiement = null;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}
	
	
	
	

}
