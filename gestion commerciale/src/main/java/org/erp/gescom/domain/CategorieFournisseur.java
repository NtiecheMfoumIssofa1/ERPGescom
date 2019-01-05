package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;


@Document(collection="categorie_fournisseur")
public class CategorieFournisseur extends AbstractAuditingEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Size(max=50)
	@Field("libelle_categorie")
	private String libelle;
	
	private boolean etat;
	
	private List<Fournisseur> fournisseurs;
	
	private List<Depense> depenses;
	
/*	public CategorieFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieFournisseur(String libelle) {
		super();
		this.libelle = libelle;
	}*/
	public String getId() {
		return id;
	}
	public void setIdCategorie(String idCategorie) {
		this.id = idCategorie;
	}
	public String getLibelleCategorie() {
		return libelle;
	}
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelle = libelleCategorie;
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
	public List<Depense> getDepenses() {
		return depenses;
	}
	public void setDepenses(List<Depense> depenses) {
		this.depenses = depenses;
	}
	
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		CategorieFournisseur c = (CategorieFournisseur) o;
		return !(c.getId() == null || getId() == null) && Objects.equals(getId(), c.getId());
	}
	
	 @Override
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }
	@Override
	public String toString() {
		return "CategorieFournisseur [idCategorie=" + id + ", libelleCategorie=" + libelle + ", etat="
				+ etat + ", fournisseurs=" + fournisseurs + ", depenses=" + depenses + "]";
	}
	 

}
