package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Commande;
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
	
	private List<String> etatFacture;
	
	private List<String> commandes;
	
	private Set<String> modeReglements;
	
	private Agence agence;
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
		this.agence = facture.getAgence();
		this.etatFacture = facture.getEtatFacture().stream()
								.map(Etat::getLibelleEtat)
								.collect(Collectors.toList());
		this.modeReglements = facture.getModeReglements().stream()
								.map(ModeReglement::getLibelleReglement)
								.collect(Collectors.toSet());
		this.commandes = facture.getCommandes().stream()
							.map(Commande::getNumCommande)
							.collect(Collectors.toList());
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
	public List<String> getEtatFacture() {
		return etatFacture;
	}
	public void setEtatFacture(List<String> etatFacture) {
		this.etatFacture = etatFacture;
	}
	
	public Set<String> getModeReglements() {
		return modeReglements;
	}
	public void setModeReglements(Set<String> modeReglements) {
		this.modeReglements = modeReglements;
	}
	public List<String> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<String> commandes) {
		this.commandes = commandes;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	
	

}
