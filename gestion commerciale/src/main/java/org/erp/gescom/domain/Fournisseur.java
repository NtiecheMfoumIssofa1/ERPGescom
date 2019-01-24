package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document(collection="fournisseur")
public class Fournisseur  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Size(max=60)
	@Field("nom_complet")
	private String nomComplet;
	
	@NotNull
	@Size(max=30)
	@Field("ville")
	private String ville;
	
	@Field("boite_postale")
	private String boitePostale;
	
	@Field("adrresse")
	private String adresse;
	
	@NotNull
	@NumberFormat
	@Field("telephone")
	private String telephone;
	
	@Email
	@NotNull
	@Field("email")
	private String email;
	
	private boolean etat;
	@JsonIgnore
	@DBRef
	private List<Article> articles;
	@DBRef
	private CategorieFournisseur categorieFournisseur; 	
	
	
	public String getIdFournisseur() {
		return id;
	}
	public void setIdFournisseur(String idFournisseur) {
		this.id = idFournisseur;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	

	
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		
		Fournisseur f = (Fournisseur) o;
		return !(f.getIdFournisseur() == null || getIdFournisseur() == null) && Objects.equals(getIdFournisseur(),f.getIdFournisseur());
	}
	@Override
    public int hashCode() {
        return Objects.hashCode(getIdFournisseur());
    }
	@Override
	public String toString() {
		return "Fournisseur [idFournisseur=" + id + ", nomComplet=" + nomComplet + ", ville=" + ville
				+ ", boitePostale=" + boitePostale + ", adresse=" + adresse + ", telephone=" + telephone + ", email="
				+ email + ", etat=" + etat + ", articles=" + articles + "]";
	}
	
	

	
	

}
