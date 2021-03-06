package org.erp.gescom.service.dto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import org.erp.gescom.domain.Fonction;
import org.erp.gescom.domain.User;
import org.springframework.data.annotation.Id;



public class FonctionDTO {
	@Id
	private String idFonction;
	@Size(max=30)
	private String libelleFonction;
	
	private List<String> appUsers;
	
	private String action ="DESACTIVEE";
	
	public FonctionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FonctionDTO(Fonction fonction) {
		this.idFonction= fonction.getIdFonction();
		this.libelleFonction = fonction.getLibelleFonction();
		this.appUsers= fonction.getAppUsers().stream()
						.map(User::getEmail)
						.collect(Collectors.toList());
	}

	public String getIdFonction() {
		return idFonction;
	}

	public void setIdFonction(String idFonction) {
		this.idFonction = idFonction;
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

	public FonctionDTO(String libelleFonction, String action) {
		super();
		this.libelleFonction = libelleFonction;
		this.action = action;
	}

	public List<String> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<String> appUsers) {
		this.appUsers = appUsers;
	}
	
	

}
