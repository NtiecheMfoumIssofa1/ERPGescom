package org.erp.gescom.service.dto;

import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.User;



public class FonctionDTO {
	
	private Long idFonction;
	private String libelleFonction;
	
	private List<User> appUsers;
	
	private String action ="DESACTIVEE";
	
	public FonctionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FonctionDTO(String libelleFonction) {
		super();
		this.libelleFonction = libelleFonction;
	}

	public Long getIdFonction() {
		return idFonction;
	}

	public void setIdFonction(Long idFonction) {
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

	public List<User> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<User> appUsers) {
		this.appUsers = appUsers;
	}
	
	

}
