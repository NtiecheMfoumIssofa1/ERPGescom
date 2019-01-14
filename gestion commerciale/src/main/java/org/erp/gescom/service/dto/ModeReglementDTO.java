package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Facture;
import org.erp.gescom.domain.ModeReglement;
import org.springframework.data.annotation.Id;

public class ModeReglementDTO {
	
	@Id
	private String libelleReglement;
	private boolean etat;
	private List<Facture>factures;
	public ModeReglementDTO() {
		
	}
	public ModeReglementDTO(ModeReglement reglement) {
		
		this.libelleReglement = reglement.getLibelleReglement();
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
