package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Devis;
import org.erp.gescom.domain.TypeClient;




public class ClientDTO {
	private Long idClient;
	private String nomComplet;
	private String adrress;
	private String ville;
	private String boitePostale;
	private String telephone;
	private String email;
	private boolean etat;
	private TypeClient typeClient;
	
	private List<Devis> devis;
	
	private ClientDTO(){
		
	}
	
	private ClientDTO(Client c){
		this.nomComplet=c.getNomComplet();
		this.adrress=c.getAdrress();
		this.ville=c.getVille();
		this.boitePostale=c.getBoitePostale();
		this.telephone=c.getTelephone();
		this.email=c.getEmail();
		this.typeClient=c.getTypeClient();
	
		this.devis=c.getDevis();
		
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
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

	public List<Devis> getDevis() {
		return devis;
	}
	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}
	

}
