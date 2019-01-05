package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;


import org.springframework.data.mongodb.core.mapping.Field;



public class SortieStock extends Stock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Field("date_sortie")
	private Instant dateSortie;

	/*public SortieStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SortieStock(String designationStock, int quantiteStock, Instant dateSortie) {
		super(designationStock, quantiteStock);
		this.dateSortie = dateSortie;
	}*/

	public Instant getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Instant dateSortie) {
		this.dateSortie = dateSortie;
	}

	@Override
	public String toString() {
		return "SortieStock [dateSortie=" + dateSortie + "]";
	}
	
	
	

}
