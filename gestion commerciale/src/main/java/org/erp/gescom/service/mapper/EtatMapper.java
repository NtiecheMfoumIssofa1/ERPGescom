package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.Facture;
import org.erp.gescom.service.dto.EtatDTO;
import org.springframework.stereotype.Service;

@Service
public class EtatMapper {
	
	public EtatDTO etatToEtatDTO(Etat etat){
		return new EtatDTO(etat);
	}
	
	public List<EtatDTO> etatsToEtatDTO(List<Etat> etats){
		return etats.stream()
					.filter(Objects::nonNull)
					.map(this::etatToEtatDTO)
					.collect(Collectors.toList());
	}
	
	public Etat etatDTOToEtat(EtatDTO etatDTO){
		
		if(etatDTO == null){
			return null;
		}else{
			Etat etat = new Etat();
			etat.setIdEtat(etatDTO.getIdEtat());
			etat.setLibelleEtat(etatDTO.getLibelleEtat());
			etat.setEtat(etatDTO.isEtat());
			Set<Commande> commandes = this.commandeFromString(etatDTO.getCommandes());
				if(commandes != null){
					etat.setCommandes(commandes);
				}
			Set<Facture> factures = this.factureFromSting(etatDTO.getFactures());
				if(factures!=null){
					etat.setFactures(factures);
				}
			return etat;	
			
		}
		
	}
	
	public List<Etat> etatDTOsToEtats(List<EtatDTO>etatDTOs){
		return etatDTOs.stream()
					.filter(Objects::nonNull)
					.map(this::etatDTOToEtat)
					.collect(Collectors.toList());
	}
	
	public Set<Commande> commandeFromString(Set<String>strings){
		return strings.stream().map(string ->{
			Commande commande = new Commande();
			commande.setNumCommande(string);
			return commande;
		}).collect(Collectors.toSet());
	}
	
	public Set<Facture> factureFromSting(Set<String> strings){
		return strings.stream().map(string ->{
			Facture facture = new Facture();
			facture.setIdFacture(string);
			return facture;
		}).collect(Collectors.toSet());
	}

}
