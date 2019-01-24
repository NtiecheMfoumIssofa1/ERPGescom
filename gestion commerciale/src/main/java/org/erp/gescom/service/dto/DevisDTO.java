package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Devis;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class DevisDTO {
	
	private String numeroDevis;
	
	private Instant dateDebutDebit;
	
	
	private Instant dateEcheanceDevis;
	
	@NumberFormat
	private int nombre;
	
	private boolean etat;
	@JsonIgnore
	private Set<String> articles ;
	@DBRef
	private Client client;
	@NumberFormat
	private double montantTTC;
	public DevisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DevisDTO(Devis devis) {
		
		this.numeroDevis = devis.getNumeroDevis();
		this.dateDebutDebit = Instant.now();//date Debut Devis
		this.dateEcheanceDevis = devis.getDateEcheanceDevis();
		this.nombre = devis.getNombre();
		this.client = devis.getClient();
		this.montantTTC = devis.getMontantTTC();
		this.articles = devis.getArticles().stream()
						.map(Article::getRefArticle)
						.collect(Collectors.toSet());
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
	public Set<String> getArticles() {
		return articles;
	}
	public void setArticles(Set<String> articles) {
		this.articles = articles;
	}
	
	
	
	

}
