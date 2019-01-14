package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;


import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;

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
	@Field("tva")
	private double tva;
	
	@NumberFormat
	@Field("quantite_article")
	private int quantiteArticle;
	
	@NumberFormat
	@Field("quantite_seuil")
	private  int quantiteSeuil;
	
	@Field("date_livraison")
	private Instant dateLivraison = null;
	
	//private FamilleArticle familleArticle;
	
	//private Taxes taxes;
	
	private boolean etat = false;
	
	//private Fournisseur fournisseur;
	
	//private Stock stock;
	
	private Instant dateMiseAjour = null;
	
	private String image;
	

/*	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String refArticle, String designation, double prixUnitaire, double tva, int quantiteArticle,
			int quantiteSeuil, Instant dateLivraison) {
		super();
		this.ref= refArticle;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.tva = tva;
		this.quantiteArticle = quantiteArticle;
		this.quantiteSeuil = quantiteSeuil;
		this.dateLivraison = dateLivraison;
	}*/
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
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
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
		return "Article [ref=" + ref + ", designation=" + designation + ", prixUnitaire=" + prixUnitaire + ", tva="
				+ tva + ", quantiteArticle=" + quantiteArticle + ", quantiteSeuil=" + quantiteSeuil + ", dateLivraison="
				+ dateLivraison + ", etat=" + etat + ", dateMiseAjour=" + dateMiseAjour + ", image=" + image + "]";
	}
	

	
}
