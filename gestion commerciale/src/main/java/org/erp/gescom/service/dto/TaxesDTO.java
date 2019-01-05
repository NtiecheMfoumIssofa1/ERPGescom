package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.erp.gescom.domain.Article;
public class TaxesDTO {
	private Long idTaxe;
	private double tauxtaxe;
	private List<Article> articles;
	private boolean etat;
	public TaxesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaxesDTO(double tauxtaxe) {
		super();
		this.tauxtaxe = tauxtaxe;
	}
	public Long getIdTaxe() {
		return idTaxe;
	}
	public void setIdTaxe(Long idTaxe) {
		this.idTaxe = idTaxe;
	}
	public double getTauxtaxe() {
		return tauxtaxe;
	}
	public void setTauxtaxe(double tauxtaxe) {
		this.tauxtaxe = tauxtaxe;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	

}
