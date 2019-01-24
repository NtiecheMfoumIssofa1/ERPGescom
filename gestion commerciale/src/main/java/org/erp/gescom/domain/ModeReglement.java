package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//debut annotation heritage
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
	  @JsonSubTypes.Type(value = Cheque.class, name = "CHEQUE"),
	  @JsonSubTypes.Type(value = Livraison.class, name = "LIVRAISON"),
	  @JsonSubTypes.Type(value = MtnMobileMoney.class, name = "MTN"),
	  @JsonSubTypes.Type(value =  OrangeMoney.class, name= "ORANGE")
	})
//fin annotation héritage
@Document(collection="mode_reglement")
//@RestResource(path="abstractFoos")
public  class ModeReglement  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private   String libelleReglement;

	@JsonIgnore
	@DBRef
	private List<Facture>factures;
	
	

	public ModeReglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ModeReglement(String id, String libelleReglement,List<Facture>factures) {
		super();
		this.id = id;
		this.libelleReglement = libelleReglement;
		this.factures = factures;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelleReglement() {
		return libelleReglement;
	}

	public void setLibelleReglement(String libelleReglement) {
		this.libelleReglement = libelleReglement;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	
	
	  
}
