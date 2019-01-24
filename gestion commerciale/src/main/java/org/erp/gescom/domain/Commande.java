package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Document(collection="commande")
public class Commande  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String numero;
	
	@Size(max=50)
	@Field("libelle_commande")
	@NotNull
	private String libelleCommande;
	
	@Field("date_commande")
	private Instant date = null;
	
	private boolean etat;
	@DBRef
	private Client client;
	@DBRef
	private Facture facture;
	@JsonIgnore
	@DBRef
	private List<Etat> etatCommandes;
	@JsonIgnore
	@DBRef
	private Set<LigneCommande> items;
	
	public String getNumCommande() {
		return numero;
	}
	public void setNumCommande(String numCommande) {
		this.numero = numCommande;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public String getLibelleCommande() {
		return libelleCommande;
	}
	public void setLibelleCommande(String libelleCommande) {
		this.libelleCommande = libelleCommande;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	public List<Etat> getEtatCommandes() {
		return etatCommandes;
	}
	public void setEtatCommandes(List<Etat> etatCommandes) {
		this.etatCommandes = etatCommandes;
	}
	
	public Set<LigneCommande> getItems() {
		return items;
	}
	public void setItems(Set<LigneCommande> items) {
		this.items = items;
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
	public boolean equals(Object o){
		if( this == o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Commande c = (Commande) o;
		return !(c.getNumCommande() == null || getNumCommande() == null) && Objects.equals(getNumCommande(), c.getNumCommande());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getNumCommande());
    }
	@Override
	public String toString() {
		return "Commande [numero=" + numero + ", libelleCommande=" + libelleCommande + ", date=" + date + ", etat="
				+ etat + ", etatCommandes=" + etatCommandes + "]";
	}
	
	

}
