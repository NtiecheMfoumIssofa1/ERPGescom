package org.erp.gescom.service.dto;

import javax.validation.constraints.NotNull;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.LigneCommande;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

public class LigneCommandeDTO {
	
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
	
	@DBRef
	private Commande commande;
	
	 public	LigneCommandeDTO(){
		 
	 }
	 
	 public LigneCommandeDTO(LigneCommande ligneCommande){
		 this.id = ligneCommande.getId();
		 this.prixUnitaire=ligneCommande.getPrixUnitaire();
		 this.quantite = ligneCommande.getQuantite();
		 this.commande = ligneCommande.getCommande();
	 }

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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	

}
