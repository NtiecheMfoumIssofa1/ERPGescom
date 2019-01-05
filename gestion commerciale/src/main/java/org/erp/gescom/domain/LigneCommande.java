package org.erp.gescom.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

public class LigneCommande  extends AbstractAuditingEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field("quantite")
	@NumberFormat
	private Double quantite;
	
	@NotNull
	@Field("prix_unitaire")
	@NumberFormat
	private Double prixUnitaire;
	
	private  Article article;
	
	private Commande commande;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public boolean equals(Object o){
		if( this == o){
			return true;
		}
		if (o == null || getClass() != o.getClass()){
			return false;
		}
		
		LigneCommande l = (LigneCommande) o;
		return !(l.getId() == null || getId() == null) && Objects.equals(getId(), l.getId());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire + ", article="
				+ article + ", commande=" + commande + "]";
	}
	

}
