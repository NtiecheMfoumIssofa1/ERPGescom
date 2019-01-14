package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Depence;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.NumberFormat;



public class DepenseDTO {
	
	@Id
	private String numeroDepense;
	
	@Size(max=30)
	private String libelleDepnse;
	
	@Size(max=25)
	private String destinataire;
	
	private Instant dateDepense;
	
	@NumberFormat
	private double montant;
	
	private boolean etat;

	private CategorieFournisseur categorieFournisseur;
	
	public DepenseDTO(){
		
	}
	public DepenseDTO(Depence d){
		this.libelleDepnse=d.getLibelleDepnse();
		this.destinataire=d.getDestinataire();
		this.dateDepense=d.getDateDepanse();
		this.montant=d.getMontant();
		//this.categorieFournisseur=d.getCategorieFournisseur();
		
	}
	public String getNumeroDepense() {
		return numeroDepense;
	}
	public void setNumeroDepense(String numeroDepense) {
		this.numeroDepense = numeroDepense;
	}
	public String getLibelleDepnse() {
		return libelleDepnse;
	}
	public void setLibelleDepnse(String libelleDepnse) {
		this.libelleDepnse = libelleDepnse;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public Instant getDateDepanse() {
		return dateDepense;
	}
	public void setDateDepanse(Instant dateDepanse) {
		this.dateDepense = dateDepanse;
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
		return "DepenseDTO [numeroDepense=" + numeroDepense + ", libelleDepnse=" + libelleDepnse + ", destinataire="
				+ destinataire + ", dateDepense=" + dateDepense + ", montant=" + montant + ", etat=" + etat
				+ ", categorieFournisseur=" + categorieFournisseur + "]";
	}
	
	

}
