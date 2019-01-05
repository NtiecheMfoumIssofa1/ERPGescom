package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Facture;

public class ModeReglementDTO {

	private String libelleReglement;
	private boolean etat;
	private List<Facture>factures;
	public ModeReglementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModeReglementDTO(String libelleReglement) {
		super();
		this.libelleReglement = libelleReglement;
	}
	
	public String getLibelleReglement() {
		return libelleReglement;
	}
	public void setLibelleReglement(String libelleReglement) {
		this.libelleReglement = libelleReglement;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	

}
