package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.springframework.data.annotation.Id;


public class EtatDTO {
	
	@Id
	private String idEtat;
	
	@Size(max=30)
	private String libelleEtat;
	private boolean etat;
	
	private Set<Commande>commandes;
	
	private Set<Facture>factures; 
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
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	public Set<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	
	

}
