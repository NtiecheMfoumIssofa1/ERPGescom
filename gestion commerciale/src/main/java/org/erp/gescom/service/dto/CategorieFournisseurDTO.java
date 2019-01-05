package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Depense;
import org.erp.gescom.domain.Fournisseur;



public class CategorieFournisseurDTO {
	
	
	private Long idCategorie;
	private String libelleCategorie;
	private boolean etat;
	
	private List<Fournisseur> fournisseurs;
	private List<Depense> depenses;
	
	public CategorieFournisseurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategorieFournisseurDTO(CategorieFournisseur c){
		this.libelleCategorie=c.getLibelleCategorie();
		this.fournisseurs=c.getFournisseurs();
		this.depenses=c.getDepenses();
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
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
	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public List<Depense> getDepenses() {
		return depenses;
	}

	public void setDepenses(List<Depense> depenses) {
		this.depenses = depenses;
	}
	
	

}
