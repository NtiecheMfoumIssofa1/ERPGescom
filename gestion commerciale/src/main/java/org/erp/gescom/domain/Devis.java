package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="devis")
public class Devis  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numero;
	
	@Field("date_debut")
	private Instant dateDebutDebit;
	
	@Field("date_echeance")
	private Instant dateEcheanceDevis;
	
	@NumberFormat
	@Field("nombre")
	private int nombre;
	
	private boolean etat;
	@JsonIgnore
	@DBRef
	private Set<Article> articles ;
	@DBRef
	private Client client;
	@NumberFormat
	@Field("montant_TTc")
	private double montantTTC;
	
	
	public String getNumeroDevis() {
		return numero;
	}
	public void setNumeroDevis(String numeroDevis) {
		this.numero = numeroDevis;
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
	
	
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Devis d = (Devis) o;
		return !(d.getNumeroDevis() == null || getNumeroDevis() == null) && Objects.equals(getNumeroDevis(),d.getNumeroDevis());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getNumeroDevis());
    }
	@Override
	public String toString() {
		return "Devis [numero=" + numero + ", dateDebutDebit=" + dateDebutDebit + ", dateEcheanceDevis="
				+ dateEcheanceDevis + ", nombre=" + nombre + ", etat=" + etat +  ", montantTTC="
				+ montantTTC + "]";
	}
	
	
	
	
	

}
