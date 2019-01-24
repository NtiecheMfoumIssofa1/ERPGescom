package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Devis;
import org.erp.gescom.domain.Statut;
import org.erp.gescom.domain.TypeClient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;




public class ClientDTO {
	
	@Id
	private String idClient;
	
	@Size(max=60)
	@NotNull
	private String nomComplet;
	
	@Size(max=50)
	private String adrress;
	
	@Size(max=30)
	@Indexed
	private String ville;
	
	@Size(max=15)
	private String boitePostale;
	
	@Size(max=15)
	private String telephone;
	
	@Email
    @Size(min = 5, max = 254)
	private String email;
	
	private boolean etat;

	private TypeClient typeClient;
	@JsonIgnore
	private List<String> commandes;
	@JsonIgnore
	private List<String> devis;
	@JsonIgnore
	private List<String> statuts;
	
	public ClientDTO(){
		
	}
	
	public ClientDTO(Client c){
		this.idClient = c.getId();
		this.nomComplet=c.getNomComplet();
		this.adrress=c.getAdrress();
		this.ville=c.getVille();
		this.boitePostale=c.getBoitePostale();
		this.telephone=c.getTelephone();
		this.email=c.getEmail();
		this.typeClient=c.getTypeClient();
		this.devis=c.getDevis().stream()
						.map(Devis::getNumeroDevis)
						.collect(Collectors.toList());
		this.commandes = c.getCommandes().stream()
							.map(Commande::getLibelleCommande)
							.collect(Collectors.toList());
		this.statuts = c.getStatuts().stream()
							.map(Statut :: getLibelleStatut)
							.collect(Collectors.toList());
		
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public TypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}

	public List<String> getDevis() {
		return devis;
	}
	public void setDevis(List<String> devis) {
		this.devis = devis;
	}

	public List<String> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<String> commandes) {
		this.commandes = commandes;
	}

	public List<String> getStatuts() {
		return statuts;
	}

	public void setStatuts(List<String> statuts) {
		this.statuts = statuts;
	}
	

}
