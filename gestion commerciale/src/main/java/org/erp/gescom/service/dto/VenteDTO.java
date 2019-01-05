package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.Facture;

public class VenteDTO  {
	
	private String numVente;
	private LocalDate dateVente;
	private int nombreArctivle;
	private boolean etat;
	private List<Article> articles;
	private Client client;
	private Facture facture;
	public VenteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VenteDTO(String numVente, LocalDate dateVente, int nombreArctivle) {
		super();
		this.numVente = numVente;
		this.dateVente = dateVente;
		this.nombreArctivle = nombreArctivle;
	}
	public String getNumVente() {
		return numVente;
	}
	public void setNumVente(String numVente) {
		this.numVente = numVente;
	}
	public LocalDate getDateVente() {
		return dateVente;
	}
	public void setDateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}
	public int getNombreArctivle() {
		return nombreArctivle;
	}
	public void setNombreArctivle(int nombreArctivle) {
		this.nombreArctivle = nombreArctivle;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	

}
