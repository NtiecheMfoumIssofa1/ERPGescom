package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import org.erp.gescom.domain.Client;


public class DevisDTO {
	private Long numeroDevis;
	private Instant dateDebutDebit;
	private Instant dateEcheanceDevis;
	private int nombre;
	private boolean etat;
	
	private Client client;
	private double montantTTC;
	public DevisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DevisDTO(Long numeroDevis, Instant dateDebutDebit, Instant dateEcheanceDevis, int nombre,
			double montantTTC) {
		super();
		this.numeroDevis = numeroDevis;
		this.dateDebutDebit = dateDebutDebit;
		this.dateEcheanceDevis = dateEcheanceDevis;
		this.nombre = nombre;
		this.montantTTC = montantTTC;
	}
	public Long getNumeroDevis() {
		return numeroDevis;
	}
	public void setNumeroDevis(Long numeroDevis) {
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
