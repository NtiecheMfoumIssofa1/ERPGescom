package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="famille_article")
public class FamilleArticle extends AbstractAuditingEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field("libelle_famille")
	private String libelleFamille;
	
	private boolean etat;  
	
	private List<Article> articles;
	
	/*public FamilleArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilleArticle(String libelleFamille) {
		super();
		this.libelleFamille = libelleFamille;
	}*/
	public String getIdFamille() {
		return id;
	}
	public void setIdFamille(String idFamille) {
		this.id = idFamille;
	}
	public String getLibelleFamille() {
		return libelleFamille;
	}
	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		FamilleArticle f = (FamilleArticle) o;
		return !(f.getIdFamille() == null || getIdFamille() == null) && Objects.equals(getIdFamille(),f.getIdFamille());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdFamille());
    }
	@Override
	public String toString() {
		return "FamilleArticle [id=" + id + ", libelleFamille=" + libelleFamille + ", etat=" + etat + ", articles="
				+ articles + "]";
	}
	

}
