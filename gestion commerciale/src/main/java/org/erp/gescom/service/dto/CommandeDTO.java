package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.domain.LigneCommande;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class CommandeDTO {
	
	@Id
	private String numCommande;
	
	@Size(max=50)
	@NotNull
	private String libelleCommande;
	

	private Instant date = null;
	
	private boolean etat;
	
	private Client client;

	private Facture facture;
	@JsonIgnore
	private List<String> etatCommandes;
	@JsonIgnore
	private Set<String> ligneCommandes;
	
	public CommandeDTO(){
		
	}
	public CommandeDTO(Commande c){
		this.libelleCommande=c.getLibelleCommande();
		this.date=c.getDate();
		this.numCommande = c.getNumCommande();
		this.client = c.getClient();
		this.facture = c.getFacture();
		this.etatCommandes = c.getEtatCommandes().stream()
								.map(Etat::getLibelleEtat)
								.collect(Collectors.toList());
		this.ligneCommandes = c.getItems().stream()
								.map(LigneCommande::getId)
								.collect(Collectors.toSet());
	}

	public String getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(String numCommande) {
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
	
	public List<String> getEtatCommandes() {
		return etatCommandes;
	}
	public void setEtatCommandes(List<String> etatCommandes) {
		this.etatCommandes = etatCommandes;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<String> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(Set<String> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	

}
