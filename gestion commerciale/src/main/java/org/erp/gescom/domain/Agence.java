package org.erp.gescom.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="agence")
public class Agence extends AbstractAuditingEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field("description")
	@Size(min = 10, max=50)
	private String description;
	
	@NotNull
	@Field("address")
	@Size( max=30)
	private String address;
	
	@NotNull
	@Field("telephone")
	@Size( max=50)
	private String telephone;
	
	@Email
	@Field("email")
	@NotNull
	private String email;
	
	private Set<Facture > factures;
	
	private Ville ville;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	
	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Agence a = (Agence) o;
		return !(a.getId() == null || getId() == null) && Objects.equals(getId(),a.getId());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "Agence [id=" + id + ", description=" + description + ", address=" + address + ", telephone=" + telephone
				+ ", email=" + email + ", factures=" + factures + "]";
	}
	

}
