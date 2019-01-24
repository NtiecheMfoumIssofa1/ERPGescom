package org.erp.gescom.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document(collection="ville")
public class Ville  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field("libelle")
	@Size(max=30)
	private String libelle;
	@JsonIgnore
	@DBRef
	private List<Agence> agences ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Ville v = (Ville) o;
		return !(v.getId() == null || getId() == null) && Objects.equals(getId(),v.getId());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "Ville [id=" + id + ", libelle=" + libelle + ", agences=" + agences + "]";
	}
	

}
