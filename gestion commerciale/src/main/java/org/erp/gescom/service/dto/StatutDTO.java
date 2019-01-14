package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.domain.Statut;
import org.springframework.data.annotation.Id;

public class StatutDTO {
	@Id
	private String idStatut;
	
	@Size(max=40)
	private String libelleStatut;
	private boolean etat;

	private List<Fournisseur> fournisseurs;
	
	
	public StatutDTO() {
		
	}
	public StatutDTO(Statut statut) {
		super();
		this.idStatut = statut.getIdStatut();
		this.libelleStatut = statut.getLibelleStatut();
		this.fournisseurs = statut.getFournisseurs();
	}
	public String getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(String idStatut) {
		this.idStatut = idStatut;
	}
	public String getLibelleStatut() {
		return libelleStatut;
	}
	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
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
	
	

}
