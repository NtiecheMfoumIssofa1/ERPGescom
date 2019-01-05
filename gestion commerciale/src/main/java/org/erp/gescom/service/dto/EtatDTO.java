package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Facture;


public class EtatDTO {
	
	private Long idEtat;
	private String libelleEtat;
	private boolean etat;
	
	private Set<Commande>commandes;
	
	private Set<Facture>factures; 
	public EtatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EtatDTO(String libelleEtat) {
		super();
		this.libelleEtat = libelleEtat;
	}
	public Long getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(Long idEtat) {
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
