package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;


@Document(collection="depenses")
public class Depense extends AbstractAuditingEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numero;
	
	@NotNull
	@Field("libelle_depense")
	private String libelleDepnse;
	
	@NotNull
	@Field("destinataire")
	@Size(max=50)
	private String destinataire;
	
	@Field("date_depense")
	private Instant dateDepanse = null ;
	
	@NumberFormat
	@NotNull
	@Field("montant")
	private double montant;
	
	private boolean etat;

	private CategorieFournisseur categorieFournisseur;
	
	/*public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Depense(String libelleDepnse, String destinataire, Instant dateDepanse,double montant) {
		super();
		this.libelleDepnse = libelleDepnse;
		this.destinataire = destinataire;
		this.dateDepanse = dateDepanse;
		this.montant = montant;
	}*/
	public String getNumeroDepense() {
		return numero;
	}
	public void setNumeroDepense(String numeroDepense) {
		this.numero = numeroDepense;
	}
	public String getLibelleDepnse() {
		return libelleDepnse;
	}
	public void setLibelleDepnse(String libelleDepnse) {
		this.libelleDepnse = libelleDepnse;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public Instant getDateDepanse() {
		return dateDepanse;
	}
	public void setDateDepanse(Instant dateDepanse) {
		this.dateDepanse = dateDepanse;
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
		Depense d = (Depense) o;
		return !(d.getNumeroDepense() == null || getNumeroDepense() == null) && Objects.equals(getNumeroDepense(), d.getNumeroDepense());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getNumeroDepense());
    }
	@Override
	public String toString() {
		return "Depense [numero=" + numero + ", libelleDepnse=" + libelleDepnse + ", destinataire=" + destinataire
				+ ", dateDepanse=" + dateDepanse + ", montant=" + montant + ", etat=" + etat + ", categorieFournisseur="
				+ categorieFournisseur + "]";
	}
	
	
	

}
