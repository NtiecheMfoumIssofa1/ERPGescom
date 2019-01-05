package org.erp.gescom.domain;

import java.io.Serializable;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;



public class Client extends AbstractAuditingEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Size(max=60)
	@Field("nom_complet")
	@NotNull
	private String nomComplet;
	
	@Size(max=50)
	@Field("adrress")
	private String adrress;
	
	@Size(max=30)
	@Field("ville")
	@Indexed
	private String ville;
	
	@Size(max=15)
	@Field("boite_postal")
	private String boitePostale;
	
	@Size(max=15)
	@Field("telephone")
	private String telephone;
	
	@Email
    @Size(min = 5, max = 254)
    @Indexed
	private String email;
	
	private boolean etat;
	
	private TypeClient typeClient;
	
	private List<Commande> commandes;
	
	private List<Devis> devis;
	
	private List<Statut> statuts;
	
	/*public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomComplet, String adrress, String ville, String boitePostale, String telephone,
			String email) {
		super();
		this.nomComplet = nomComplet;
		this.adrress = adrress;
		this.ville = ville;
		this.boitePostale = boitePostale;
		this.telephone = telephone;
		this.email = email;
	}*/

	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
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
	public TypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public List<Devis> getDevis() {
		return devis;
	}
	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}
	
	public List<Statut> getStatuts() {
		return statuts;
	}
	public void setStatuts(List<Statut> statuts) {
		this.statuts = statuts;
	}
	public boolean equals(Object o){
		if(this == o){
			return true;
		}
		if( o == null || getClass() != o.getClass()){
			return false;
		}
		Client client = (Client) o;
		return !(client.getId() == null || getId() == null) && Objects.equals(getId(), client.getId());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
	@Override
	public String toString() {
		return "Client [id=" + id + ", nomComplet=" + nomComplet + ", adrress=" + adrress + ", ville=" + ville
				+ ", boitePostale=" + boitePostale + ", telephone=" + telephone + ", email=" + email + ", etat=" + etat
				+ ", typeClient=" + typeClient + ", commande=" + commandes + ", devis=" + devis + ", statut=" + statuts + "]";
	}
	
	
}
