package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document(collection="fonction")
public class Fonction  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field("libelle_fonction")
	private String libelleFonction;
	@JsonIgnore
	@DBRef
	private List<User> appUsers;
	
	private String action ="DESACTIVEE";
	
	

	public String getIdFonction() {
		return id;
	}

	public void setIdFonction(String idFonction) {
		this.id = idFonction;
	}

	public String getLibelleFonction() {
		return libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<User> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<User> appUsers) {
		this.appUsers = appUsers;
	}
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Fonction f = (Fonction) o;
		return !(f.getIdFonction() == null || getIdFonction() == null) && Objects.equals(getIdFonction(),f.getIdFonction());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdFonction());
    }

	@Override
	public String toString() {
		return "Fonction [id=" + id + ", libelleFonction=" + libelleFonction + ", appUsers=" + appUsers + ", action="
				+ action + "]";
	}
	

}
