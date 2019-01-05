package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Client;

public class TypeClientDTO {
	private Long idType;
	private String libelleType;
	private List<Client> clients;
	private boolean etat;
	public TypeClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeClientDTO(String libelleType, boolean etat) {
		super();
		this.libelleType = libelleType;
		this.etat = etat;
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
