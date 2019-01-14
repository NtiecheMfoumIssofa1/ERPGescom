package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.domain.ModeReglement;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.NumberFormat;



public class FactureDTO {
	@Id
	private String idFacture;
	private Instant dateDebutFacture;
	private Instant dateEcheanceFacture;
	@NumberFormat
	private double montantTTC;
	private boolean etat;
	
	private List<Etat> etatFacture;
	
	
	
	private Set<ModeReglement> modeReglements;
	public FactureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FactureDTO(Facture facture) {
		super();
		this.idFacture = facture.getIdFacture();
		this.dateDebutFacture = facture.getDateDebutFacture();
		this.dateEcheanceFacture = facture.getDateEcheanceFacture();
		this.montantTTC = facture.getMontantTTC();
	}
	public String getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(String idFacture) {
		this.idFacture = idFacture;
	}
	public Instant getDateDebutFacture() {
		return dateDebutFacture;
	}
	public void setDateDebutFacture(Instant dateDebutFacture) {
		this.dateDebutFacture = dateDebutFacture;
	}
	public Instant getDateEcheanceFacture() {
		return dateEcheanceFacture;
	}
	public void setDateEcheanceFacture(Instant dateEcheanceFacture) {
		this.dateEcheanceFacture = dateEcheanceFacture;
	}
	public double getMontantTTC() {
		return montantTTC;
	}
	public void setMontantTTC(double montantTTC) {
		this.montantTTC = montantTTC;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Etat> getEtatFacture() {
		return etatFacture;
	}
	public void setEtatFacture(List<Etat> etatFacture) {
		this.etatFacture = etatFacture;
	}
	
	public Set<ModeReglement> getModeReglements() {
		return modeReglements;
	}
	public void setModeReglements(Set<ModeReglement> modeReglements) {
		this.modeReglements = modeReglements;
	}
	
	
	

}
