package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;


import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection="article")
public class Article  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String ref;
	
	@Size(max=100)
	@Field("designation")
	private String designation;
	
	@NumberFormat
	@Field("prix_unitaire")
	private double prixUnitaire;
	
	@NumberFormat
	@Field("quantite_article")
	private int quantiteArticle;
	
	@NumberFormat
	@Field("quantite_seuil")
	private  int quantiteSeuil;
	
	@Field("date_livraison")
	private Instant dateLivraison = null;
	@DBRef
	private FamilleArticle familleArticle;
	@JsonIgnore
	@DBRef
	private Set<Taxes> taxes ;
	
	private boolean etat = false;
	@DBRef
	private Fournisseur fournisseur;
	@DBRef
	private Stock stock;
	@DBRef
	private Devis devis;
	
	private Instant dateMiseAjour = null;
	
	private String image;
	


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
		return quantiteArticle;
	}
	public void setQuantiteArticle(int quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
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
	
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	public Instant getDateMiseAjour() {
		return dateMiseAjour;
	}
	public void setDateMiseAjour(Instant dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<Taxes> getTaxes() {
		return taxes;
	}
	public void setTaxes(Set<Taxes> taxes) {
		this.taxes = taxes;
	}
	public FamilleArticle getFamilleArticle() {
		return familleArticle;
	}
	public void setFamilleArticle(FamilleArticle familleArticle) {
		this.familleArticle = familleArticle;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Devis getDevis() {
		return devis;
	}
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
	public boolean equals (Object o){
		if(this == o ){
			return true;
		}
		if (o == null || getClass() != o.getClass()){
			return false;
		}
		Article a = (Article) o;
		return !(a.getRefArticle() == null || getRefArticle() == null) && Objects.equals(getRefArticle(), a.getRefArticle());
	}
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(getRefArticle());
	    }
	@Override
	public String toString() {
		return "Article [ref=" + ref + ", designation=" + designation + ", prixUnitaire=" + prixUnitaire + 
				 ", quantiteArticle=" + quantiteArticle + ", quantiteSeuil=" + quantiteSeuil + ", dateLivraison="
				+ dateLivraison + ", etat=" + etat + ", dateMiseAjour=" + dateMiseAjour + ", image=" + image + "]";
	}
	

	
}
