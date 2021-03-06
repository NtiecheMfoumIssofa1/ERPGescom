package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="facture")
public class Facture  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Field("date_debut")
	private Instant dateDebutFacture;
	
	@Field("date_echeance")
	private Instant dateEcheanceFacture;
	
	@NumberFormat
	@Field("montant_TTc")
	private double montantTTC;
	
	private boolean etat;
	@JsonIgnore
	@DBRef
	private List<Etat> etatFacture;
	@JsonIgnore
	@DBRef
	private List<Commande>  commandes;
	@JsonIgnore
	@DBRef
	private Set<ModeReglement> modeReglements;
	
	@DBRef
	private Agence agence;
	@DBRef
	private ModeReglement modeReglement;
	
	public String getIdFacture() {
		return id;
	}
	public void setIdFacture(String idFacture) {
		this.id = idFacture;
	}
	public Instant getDateDebutFacture() {
		return dateDebutFacture;
	}
	public void setDateDebutFacture(Instant dateDebutFacture) {
		this.dateDebutFacture = dateDebutFacture;
	}
	public Instant getDateEcheanceFacture() {
		return dateEcheanceFacture;
	}
	public void setDateEcheanceFacture(Instant dateEcheanceFacture) {
		this.dateEcheanceFacture = dateEcheanceFacture;
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
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public List<Etat> getEtatFacture() {
		return etatFacture;
	}
	public void setEtatFacture(List<Etat> etatFacture) {
		this.etatFacture = etatFacture;
	}

	public Set<ModeReglement> getModeReglements() {
		return modeReglements;
	}
	public void setModeReglements(Set<ModeReglement> modeReglements) {
		this.modeReglements = modeReglements;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	

	public ModeReglement getModeReglement() {
		return modeReglement;
	}
	public void setModeReglement(ModeReglement modeReglement) {
		this.modeReglement = modeReglement;
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Facture f = (Facture) o;
		return !(f.getIdFacture() == null || getIdFacture() == null) && Objects.equals(getIdFacture(),f.getIdFacture());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdFacture());
    }
	@Override
	public String toString() {
		return "Facture [id=" + id + ", dateDebutFacture=" + dateDebutFacture + ", dateEcheanceFacture="
				+ dateEcheanceFacture + ", montantTTC=" + montantTTC + ", etat=" + etat + ", etatFacture=" + etatFacture
				+ ", commandes=" + commandes + ", modeReglements=" + modeReglements + "]";
	}
	

}
