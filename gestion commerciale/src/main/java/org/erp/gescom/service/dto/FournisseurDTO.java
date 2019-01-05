package org.erp.gescom.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.CategorieFournisseur;
import org.erp.gescom.domain.Commande;



public class FournisseurDTO {
	
	private Long idFournisseur;
	private String nomComplet;
	private String ville;
	private String boitePostale;
	private String adresse;
	private String telephone;
	private String email;
	private boolean etat;
	
	private List<Article> articles;

	private Statut statut;
	
	private CategorieFournisseur categorieFournisseur;
	
	private Set<Commande>commandes;
	public FournisseurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FournisseurDTO(Long idFournisseur, String nomComplet, String ville, String boitePostale, String adresse,
			String telephone, String email) {
		super();
		this.idFournisseur = idFournisseur;
		this.nomComplet = nomComplet;
		this.ville = ville;
		this.boitePostale = boitePostale;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
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
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	

}
