package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Devis;
import org.erp.gescom.domain.FamilleArticle;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.domain.Stock;
import org.erp.gescom.domain.Taxes;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ArticleDTO {
	
	@Id
	private String ref;
	
	@Size(max=100)
	private String designation;
	
	@NumberFormat
	private double prixUnitaire;
	
	@NumberFormat
	@Field("quantite_article")
	private int quantite;
	
	@NumberFormat
	private  int quantiteSeuil;
	
	private Instant dateLivraison = null;
	
	private FamilleArticle familleArticle;
	@JsonIgnore
	private Set<String> taxes ;
	
	private boolean etat = false;
	private Fournisseur fournisseur;
	private Stock stock;
	private Devis devis;
	
	private Instant dateMiseAjour = null;
	
	private String image;
	

  
	public ArticleDTO() {
		
	}
	public ArticleDTO(Article a){
		this.ref=a.getRefArticle();
		this.designation=a.getDesignation();
		this.quantite=a.getQuantiteArticle();
		this.prixUnitaire=a.getPrixUnitaire();
		this.quantiteSeuil=a.getQuantiteSeuil();
		this.dateLivraison=a.getDateLivraison();
		this.familleArticle=a.getFamilleArticle();
		this.taxes=a.getTaxes().stream()
					.map(Taxes::getIdTaxe)
					.collect(Collectors.toSet());
		this.fournisseur=a.getFournisseur();
		this.stock=a.getStock();
		this.devis = a.getDevis();
		
	}
	public String getRefArticle() {
		return ref;
	}
	public void setRefArticle(String refArticle) {
		this.ref = refArticle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	public int getQuantiteArticle() {
		return quantite;
	}
	public void setQuantiteArticle(int quantiteArticle) {
		this.quantite = quantiteArticle;
	}
	public int getQuantiteSeuil() {
		return quantiteSeuil;
	}
	public void setQuantiteSeuil(int quantiteSeuil) {
		this.quantiteSeuil = quantiteSeuil;
	}
	public Instant getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Instant dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public FamilleArticle getFamilleArticle() {
		return familleArticle;
	}
	public void setFamilleArticle(FamilleArticle familleArticle) {
		this.familleArticle = familleArticle;
	}

	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Instant getDateMiseAjour() {
		return dateMiseAjour;
	}
	public void setDateMiseAjour(Instant dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Set<String> getTaxes() {
		return taxes;
	}
	public void setTaxes(Set<String> taxes) {
		this.taxes = taxes;
	}
	public Devis getDevis() {
		return devis;
	}
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
	@Override
	public String toString() {
		return "ArticleDTO [ref=" + ref + ", designation=" + designation + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite + ", quantiteSeuil=" + quantiteSeuil + ", dateLivraison="
				+ dateLivraison + ", familleArticle=" + familleArticle + ", taxes=" + taxes + ", etat=" + etat
				+ ", fournisseur=" + fournisseur + ", stock=" + stock + ", dateMiseAjour=" + dateMiseAjour + "]";
	}
	
	

}
