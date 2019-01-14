package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.Agence;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.domain.Ville;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


public class AgenceDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	
	@Size(min = 10, max=50)
	private String description;
	
	
	@Size( max=30)
	private String address;
	
	
	@Size( max=50)
	private String telephone;
	
	@Email
	@NotNull
	private String email;
	
	private Set<String > factures;
	
	private Ville ville;

	
	
	public AgenceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgenceDTO(Agence agence) {
	
		this.id = agence.getId();
		this.description = agence.getDescription();
		this.address = agence.getAddress();
		this.telephone = agence.getTelephone();
		this.email = agence.getEmail();				
		//this.ville = agence.getVille();
		this.factures = agence.getFactures().stream()
				.map(Facture::getIdFacture)
				.collect(Collectors.toSet());
	}

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

	public Set<String> getFactures() {
		return factures;
	}

	public void setFactures(Set<String> factures) {
		this.factures = factures;
	}
	
	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

}
