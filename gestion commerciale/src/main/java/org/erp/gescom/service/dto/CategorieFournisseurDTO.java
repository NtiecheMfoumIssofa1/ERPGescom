package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Depence;
import org.erp.gescom.domain.Fournisseur;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class CategorieFournisseurDTO {
	
	@Id
	private String idCategorie;
	
	@Size(max=50)
	private String libelleCategorie;
	
	private boolean etat;
	@JsonIgnore
	private List<String> fournisseurs;
	@JsonIgnore
	private List<String> depenses;
	
	public CategorieFournisseurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategorieFournisseurDTO(CategorieFournisseur c){
		this.libelleCategorie=c.getLibelleCategorie();
		this.fournisseurs=c.getFournisseurs().stream()
							.map(Fournisseur::getNomComplet)
							.collect(Collectors.toList());
		this.depenses=c.getDepenses().stream()
						.map(Depence::getLibelleDepence)
						.collect(Collectors.toList());
	}
	public String getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<String> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<String> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public List<String> getDepenses() {
		return depenses;
	}

	public void setDepenses(List<String> depenses) {
		this.depenses = depenses;
	}
	
	

}
