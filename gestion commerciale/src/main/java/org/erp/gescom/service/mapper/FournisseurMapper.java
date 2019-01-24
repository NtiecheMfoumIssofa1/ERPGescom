package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Article;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Fournisseur;
import org.erp.gescom.service.dto.FournisseurDTO;
import org.springframework.stereotype.Service;

@Service
public class FournisseurMapper {
	
	public FournisseurDTO fournisseurToFournisseurDTo(Fournisseur fournisseur){
		return new FournisseurDTO(fournisseur);
	}
	
	public List<FournisseurDTO> fournisseursToFournisseurDTos(List<Fournisseur> fournisseurs){
		return fournisseurs.stream()
					.filter(Objects::nonNull)
					.map(this::fournisseurToFournisseurDTo)
					.collect(Collectors.toList());
	}
	
	public Fournisseur fournisseurDTOToFournisseur(FournisseurDTO fournisseurDTO){
		if(fournisseurDTO == null){
			return null;
		}else{
			Fournisseur fournisseur = new Fournisseur();
			fournisseur.setAdresse(fournisseurDTO.getAdresse());
			fournisseur.setBoitePostale(fournisseurDTO.getBoitePostale());
			fournisseur.setEmail(fournisseurDTO.getEmail());
			fournisseur.setEtat(fournisseurDTO.isEtat());
			fournisseur.setIdFournisseur(fournisseurDTO.getIdFournisseur());
			fournisseur.setNomComplet(fournisseurDTO.getNomComplet());
			fournisseur.setTelephone(fournisseurDTO.getTelephone());
			fournisseur.setVille(fournisseurDTO.getVille());
			List<Article> articles = this.articleFromString(fournisseurDTO.getArticles());
			 		if(articles != null){
			 			fournisseur.setArticles(articles);
			 		}
			/*Set<Commande> commandes = this.commandeFromString(fournisseurDTO.getCommandes());
					if(commandes != null){
						fournisseur.setCommandes(commandes);
					}*/
		return fournisseur;			
			
		}
	}
	
	public List<Fournisseur> fournisseurDTOsToFournisseurs(List<FournisseurDTO> fournisseurDTOs){
		return fournisseurDTOs.stream()
					.filter(Objects::nonNull)
					.map(this::fournisseurDTOToFournisseur)
					.collect(Collectors.toList());
	}
	
	public List<Article> articleFromString(List<String> strings){
		return strings.stream().map(string ->{
			Article article = new Article();
			article.setRefArticle(string);
			return article;
		}).collect(Collectors.toList());
	}
	
	/*public Set<Commande> commandeFromString(Set<String> strings){
		return strings.stream().map(string ->{
			Commande commande = new Commande();
			commande.setNumCommande(string);
			return commande;
		}).collect(Collectors.toSet());
	}*/

}
