package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class EtatDTO {
	
	@Id
	private String idEtat;
	
	@NotNull
	@Field("libelle_etat")
	@Size(max=20)
	private String libelleEtat;
	
	private boolean etat;
	@JsonIgnore
	@DBRef
	private Set<String>commandes;
	@JsonIgnore
	@DBRef
	private Set<String>factures;
	public EtatDTO() {
		
	}
	public EtatDTO(Etat etat) {
		this.idEtat = etat.getIdEtat();
		this.libelleEtat = etat.getLibelleEtat();
	}
	public String getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(String idEtat) {
		this.idEtat = idEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Set<String> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<String> commandes) {
		this.commandes = commandes;
	}
	public Set<String> getFactures() {
		return factures;
	}
	public void setFactures(Set<String> factures) {
		this.factures = factures;
	}
	
	

}
