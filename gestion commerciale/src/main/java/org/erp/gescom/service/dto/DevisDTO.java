package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Devis;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.NumberFormat;


public class DevisDTO {
	
	@Id
	private String numeroDevis;
	private Instant dateDebutDebit;
	private Instant dateEcheanceDevis;
	@NumberFormat
	
	private int nombre;
	private boolean etat;
	
	private Client client;
	private double montantTTC;
	public DevisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DevisDTO(Devis devis) {
		
		this.numeroDevis = devis.getNumeroDevis();
		this.dateDebutDebit = devis.getDateDebutDebit();
		this.dateEcheanceDevis = devis.getDateEcheanceDevis();
		this.nombre = devis.getNombre();
		this.montantTTC = devis.getMontantTTC();
	}
	public String getNumeroDevis() {
		return numeroDevis;
	}
	public void setNumeroDevis(String numeroDevis) {
		this.numeroDevis = numeroDevis;
	}
	public Instant getDateDebutDebit() {
		return dateDebutDebit;
	}
	public void setDateDebutDebit(Instant dateDebutDebit) {
		this.dateDebutDebit = dateDebutDebit;
	}
	public Instant getDateEcheanceDevis() {
		return dateEcheanceDevis;
	}
	public void setDateEcheanceDevis(Instant dateEcheanceDevis) {
		this.dateEcheanceDevis = dateEcheanceDevis;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	

}
