package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;


@Document(collection="depenses")
public class Depence  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numero;
	
	@NotNull
	@Field("libelle_depense")
	private String libelleDepence;
	
	@NotNull
	@Field("destinataire")
	@Size(max=50)
	private String destinataire;
	
	@Field("date_depense")
	private Instant dateDepence = null ;
	
	@NumberFormat
	@NotNull
	@Field("montant")
	private double montant;
	
	private boolean etat;
	@DBRef
	private CategorieFournisseur categorieFournisseur;
	
	public String getNumeroDepence() {
		return numero;
	}
	public void setNumeroDepence(String numeroDepense) {
		this.numero = numeroDepense;
	}
	public String getLibelleDepence() {
		return libelleDepence;
	}
	public void setLibelleDepence(String libelleDepnse) {
		this.libelleDepence = libelleDepnse;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public Instant getDateDepence() {
		return dateDepence;
	}
	public void setDateDepence(Instant dateDepanse) {
		this.dateDepence = dateDepanse;
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
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		Depence d = (Depence) o;
		return !(d.getNumeroDepence() == null || getNumeroDepence() == null) && Objects.equals(getNumeroDepence(), d.getNumeroDepence());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getNumeroDepence());
    }
	@Override
	public String toString() {
		return "Depense [numero=" + numero + ", libelleDepnse=" + libelleDepence + ", destinataire=" + destinataire
				+ ", dateDepanse=" + dateDepence + ", montant=" + montant + ", etat=" + etat + "]";
	}
	
	
	

}
