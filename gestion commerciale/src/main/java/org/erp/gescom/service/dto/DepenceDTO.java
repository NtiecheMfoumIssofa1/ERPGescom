package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Depence;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;



public class DepenceDTO {
	
	@Id
	private String numeroDepense;
	
	@NotNull
	private String libelleDepence;
	
	@NotNull
	@Size(max=50)
	private String destinataire;
	
	private Instant dateDepence = null ;
	
	@NumberFormat
	@NotNull
	private double montant;
	
	private boolean etat;
	private CategorieFournisseur categorieFournisseur;
	
	
	public DepenceDTO(){
		
	}
	public DepenceDTO(Depence d){
		this.libelleDepence=d.getLibelleDepence();
		this.destinataire=d.getDestinataire();
		this.dateDepence=d.getDateDepence();
		this.montant=d.getMontant();
		this.categorieFournisseur=d.getCategorieFournisseur();
		
	}
	public String getNumeroDepence() {
		return numeroDepense;
	}
	public void setNumeroDepence(String numeroDepense) {
		this.numeroDepense = numeroDepense;
	}
	public String getLibelleDepence() {
		return libelleDepence;
	}
	public void setLibelleDepence(String libelleDepnse) {
		this.libelleDepence = libelleDepnse;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public Instant getDateDepence() {
		return dateDepence;
	}
	public void setDateDepence(Instant dateDepanse) {
		this.dateDepence = dateDepanse;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	@Override
	public String toString() {
		return "DepenseDTO [numeroDepense=" + numeroDepense + ", libelleDepnse=" + libelleDepence + ", destinataire="
				+ destinataire + ", dateDepense=" + dateDepence + ", montant=" + montant + ", etat=" + etat
				+ ", categorieFournisseur=" + categorieFournisseur + "]";
	}
	
	

}
