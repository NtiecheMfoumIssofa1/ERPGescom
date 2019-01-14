package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document(collection="statut")
public class Statut implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field("libelle_statut")
	private String libelleStatut;
	
	private boolean etat;
	@JsonIgnore
	private List<Fournisseur> fournisseurs;
	@JsonIgnore
	private List<Client> clients;
	
	/*public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Statut(String libelleStatut) {
		super();
		this.libelleStatut = libelleStatut;
	}*/
	
	public String getIdStatut() {
		return id;
	}
	public void setIdStatut(String idStatut) {
		this.id = idStatut;
	}
	public String getLibelleStatut() {
		return libelleStatut;
	}
	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Statut s = (Statut) o;
		return !(s.getIdStatut() == null || getIdStatut() == null) && Objects.equals(getIdStatut(),s.getIdStatut());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdStatut());
    }
	@Override
	public String toString() {
		return "Statut [id=" + id + ", libelleStatut=" + libelleStatut + ", etat=" + etat + ", fournisseurs="
				+ fournisseurs + ", clients=" + clients + "]";
	}
	
	

}
