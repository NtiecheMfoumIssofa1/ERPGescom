package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.ModeReglement;



public class FactureDTO {
	
	private String idFacture;
	private Instant dateDebutFacture;
	private Instant dateEcheanceFacture;
	private double montantTTC;
	private boolean etat;
	
	private List<Etat> etatFacture;
	
	
	
	private Set<ModeReglement> modeReglements;
	public FactureDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FactureDTO(String idFacture, Instant dateDebutFacture, Instant dateEcheanceFacture, double montantTTC) {
		super();
		this.idFacture = idFacture;
		this.dateDebutFacture = dateDebutFacture;
		this.dateEcheanceFacture = dateEcheanceFacture;
		this.montantTTC = montantTTC;
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
