package org.erp.gescom.domain;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="mode_reglement")
@TypeAlias("orange_money")
public class OrangeMoney extends ModeReglement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String telephone;
	
	private LocalDate datePaiement = null;
	

	



	
	
	

	public OrangeMoney(String id, String libelleReglement, List<Facture> factures, String telephone,
			LocalDate datePaiement) {
		super(id, libelleReglement, factures);
		this.telephone = telephone;
		this.datePaiement = datePaiement;
	}




	public OrangeMoney() {
		super();
		// TODO Auto-generated constructor stub
	}




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

	@Override
	public String getLibelleReglement() {
		// TODO Auto-generated method stub
		return "Paiement Par ORANGE MONEY";
	}

	
	
 
	
	
	
	

}
