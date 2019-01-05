package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Fournisseur;

public class Statut {
	
	private Long idStatut;
	private String libelleStatut;
	private boolean etat;

	private List<Fournisseur> fournisseurs;
	public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Statut(String libelleStatut) {
		super();
		this.libelleStatut = libelleStatut;
	}
	public Long getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(Long idStatut) {
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
