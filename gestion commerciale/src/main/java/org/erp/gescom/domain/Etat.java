package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="etat")
public class Etat  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@NotNull
	@Size(max=20)
	private String libelleEtat;
	
	private boolean etat;
	@JsonIgnore
	private Set<Commande>commandes;
	@JsonIgnore
	private Set<Facture>factures; 
	
	public String getIdEtat() {
		return id;
	}
	public void setIdEtat(String idEtat) {
		this.id = idEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	public Set<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Etat e = (Etat) o;
		return !(e.getIdEtat() == null || getIdEtat() == null) && Objects.equals(getIdEtat(),e.getIdEtat());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdEtat());
    }
	@Override
	public String toString() {
		return "Etat [id=" + id + ", libelleEtat=" + libelleEtat + ", etat=" + etat + ", commandes=" + commandes
				+ ", factures=" + factures + "]";
	}
	
   
}
