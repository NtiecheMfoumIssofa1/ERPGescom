package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="type_client")
public class TypeClient extends AbstractAuditingEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idType;
	
	@NotNull
	@Field("libelle_type")
	private String libelleType;
	
	private List<Client> clients;
	
	private boolean etat;
	/*public TypeClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeClient(String libelleType, boolean etat) {
		super();
		this.libelleType = libelleType;
		this.etat = etat;
	}*/
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
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		TypeClient t = (TypeClient) o;
		return !(t.getIdType() == null || getIdType() == null) && Objects.equals(getIdType(),t.getIdType());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdType());
    }
	@Override
	public String toString() {
		return "TypeClient [idType=" + idType + ", libelleType=" + libelleType + ", clients=" + clients + ", etat="
				+ etat + "]";
	}
	
	

}
