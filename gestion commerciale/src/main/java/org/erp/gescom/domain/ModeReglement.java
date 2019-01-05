package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="mode_reglement")
public class ModeReglement extends AbstractAuditingEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String libelleReglement;
	
	private boolean etat;
	
	private List<Facture>factures;
	
	/*public ModeReglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModeReglement(String libelleReglement) {
		super();
		this.libelleReglement = libelleReglement;
	}*/
	
	public String getLibelleReglement() {
		return libelleReglement;
	}
	public void setLibelleReglement(String libelleReglement) {
		this.libelleReglement = libelleReglement;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		ModeReglement m = (ModeReglement) o;
		return !(m.getLibelleReglement() == null || getLibelleReglement() == null) && Objects.equals(getLibelleReglement(),m.getLibelleReglement());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getLibelleReglement());
    }
	@Override
	public String toString() {
		return "ModeReglement [libelleReglement=" + libelleReglement + ", etat=" + etat + ", factures=" + factures
				+ "]";
	}
	
	


}
