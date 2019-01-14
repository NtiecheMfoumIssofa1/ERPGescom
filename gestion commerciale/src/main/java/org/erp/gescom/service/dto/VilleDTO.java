package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

public class VilleDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Size(max=30)
	private String libelle;
	
	private List<AgenceDTO> agences;

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

	public List<AgenceDTO> getAgences() {
		return agences;
	}

	public void setAgences(List<AgenceDTO> agences) {
		this.agences = agences;
	}
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		VilleDTO v = (VilleDTO) o;
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
