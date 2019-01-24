package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Client;
import org.erp.gescom.domain.TypeClient;
import org.springframework.data.annotation.Id;

public class TypeClientDTO {
	
	@Id
	private String idType;
	
	@Size(max=50)
	private String libelleType;
	private List<String> clients;
	private boolean etat;
	public TypeClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeClientDTO(TypeClient typeClient) {
	
		this.libelleType = typeClient.getLibelleType();
		this.clients = typeClient.getClients().stream()
							.map(Client::getNomComplet)
							.collect(Collectors.toList());
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getLibelleType() {
		return libelleType;
	}
	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}
	public List<String> getClients() {
		return clients;
	}
	public void setClients(List<String> clients) {
		this.clients = clients;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	

}
