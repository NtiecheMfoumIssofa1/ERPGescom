package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Fournisseur;



public class CommandeDTO {
	
	private Long numCommande;
	private String libelleCommande;
	private Instant date;
	private boolean etat;
	private Fournisseur fournisseur;
	private List<Etat> etatCommandes;
	
	public CommandeDTO(){
		
	}
	public CommandeDTO(Commande c){
		this.libelleCommande=c.getLibelleCommande();
		this.date=c.getDate();
		//this.fournisseur=c.getFournisseur();
		this.etatCommandes=c.getEtatCommandes();
	}

	public Long getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public String getLibelleCommande() {
		return libelleCommande;
	}
	public void setLibelleCommande(String libelleCommande) {
		this.libelleCommande = libelleCommande;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public List<Etat> getEtatCommandes() {
		return etatCommandes;
	}
	public void setEtatCommandes(List<Etat> etatCommandes) {
		this.etatCommandes = etatCommandes;
	}
	

}
