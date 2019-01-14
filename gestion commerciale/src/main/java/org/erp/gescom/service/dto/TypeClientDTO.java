package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.TypeClient;
import org.springframework.data.annotation.Id;

public class TypeClientDTO {
	
	@Id
	private Long idType;
	
	@Size(max=50)
	private String libelleType;
	private List<Client> clients;
	private boolean etat;
	public TypeClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeClientDTO(TypeClient typeClient) {
	
		this.libelleType = typeClient.getLibelleType();
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getLibelleType() {
		return libelleType;
	}
	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	

}
