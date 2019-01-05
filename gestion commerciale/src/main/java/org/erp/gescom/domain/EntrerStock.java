package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="entree_stock")
public class EntrerStock extends Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Field("date_entree")
	private Instant dateEntree= null;

	/*public EntrerStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntrerStock(String designationStock, int quantiteStock, Instant dateEntree) {
		super(designationStock, quantiteStock);
		this.dateEntree = dateEntree;
	}*/

	public Instant getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Instant dateEntree) {
		this.dateEntree = dateEntree;
	}

	@Override
	public String toString() {
		return "EntrerStock [dateEntree=" + dateEntree + "]";
	}
	
	
	

}
