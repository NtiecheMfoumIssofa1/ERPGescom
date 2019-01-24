package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Fournisseur;
import org.springframework.data.annotation.Id;



public class FournisseurDTO {
	@Id
	private String idFournisseur;
	
	@Size(max=60)
	private String nomComplet;
	
	@Size(max=30)
	private String ville;
	
	@Size(max=20)
	private String boitePostale;
	@Size(max=40)
	private String adresse;
	@Size(max=20)
	private String telephone;
	
	@Email
	@Size(max=100)
	private String email;
	private boolean etat;
	
	private List<String> articles;

	private StatutDTO statut;
	
	private CategorieFournisseur categorieFournisseur;
	
	
	public FournisseurDTO() {
		
	}
	public FournisseurDTO(Fournisseur fournisseur) {
		super();
		this.idFournisseur = fournisseur.getIdFournisseur();
		this.nomComplet = fournisseur.getNomComplet();
		this.ville = fournisseur.getVille();
		this.boitePostale = fournisseur.getBoitePostale();
		this.adresse = fournisseur.getAdresse();
		this.telephone = fournisseur.getTelephone();
		this.email = fournisseur.getEmail();
		this.categorieFournisseur=fournisseur.getCategorieFournisseur();
		this.articles = fournisseur.getArticles().stream()
						.map(Article::getRefArticle)
						.collect(Collectors.toList());
		
	}
	public String getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(String idFournisseur) {
		this.idFournisseur = idFournisseur;
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
	public List<String> getArticles() {
		return articles;
	}
	public void setArticles(List<String> articles) {
		this.articles = articles;
	}
	public StatutDTO getStatut() {
		return statut;
	}
	public void setStatut(StatutDTO statut) {
		this.statut = statut;
	}
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	
	/*public Set<String> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<String> commandes) {
		this.commandes = commandes;
	}*/
	
	
	

}
