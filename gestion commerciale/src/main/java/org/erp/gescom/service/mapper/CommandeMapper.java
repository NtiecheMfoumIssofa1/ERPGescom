package org.erp.gescom.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.erp.gescom.domain.Authority;
import org.erp.gescom.domain.Commande;
import org.erp.gescom.domain.Etat;
import org.erp.gescom.domain.LigneCommande;
import org.erp.gescom.service.dto.CommandeDTO;
import org.springframework.stereotype.Service;

@Service
public class CommandeMapper {
	
	public CommandeDTO commandeToCommandeDTo(Commande commande){
		return new CommandeDTO(commande);
	}

	public List<CommandeDTO> commandesToCommandeDTOs(List<Commande> commandes){
		
		return commandes.stream()
				.filter(Objects::nonNull)
				.map(this::commandeToCommandeDTo)
				.collect(Collectors.toList());	
	}
	
	public Commande commandeDTOToCommande(CommandeDTO commandeDTO){
		if(commandeDTO != null){
			return null;
		}
		Commande commande = new Commande();
		commande.setLibelleCommande(commandeDTO.getLibelleCommande());
		commande.setDate(commandeDTO.getDate());
		//commande.setFacture(commandeDTO.getFacture());
		//commande.setClient(commandeDTO.getClient());
		commande.setNumCommande(commandeDTO.getNumCommande());
		List<Etat> etats = this.etatFromStrings(commandeDTO.getEtatCommandes());
			if( etats != null){
				commande.setEtatCommandes(etats);
			}
		commande.setEtat(commandeDTO.isEtat());
	Set<LigneCommande> ligneCommandes = this.LigneFromStrings(commandeDTO.getLigneCommandes());
	        if( ligneCommandes != null){
	        	commande.setItems(ligneCommandes);
	        }
	      return commande;  
		
	}
	
	public List<Commande> commandeDTOsToCommandes(List<CommandeDTO> commandeDTOs){
		return commandeDTOs.stream()
				.filter(Objects::nonNull)
				.map(this::commandeDTOToCommande)
				.collect(Collectors.toList());
	}
	
	 public List<Etat> etatFromStrings(List<String> strings) {
	        return strings.stream().map(string -> {
	            Etat etat= new Etat();
	            etat.setLibelleEtat(string);
	            return etat;
	        }).collect(Collectors.toList());
	    }
	 public Set<LigneCommande> LigneFromStrings(Set<String> strings) {
	        return strings.stream().map(string -> {
	        	LigneCommande ligneCommande= new LigneCommande();
	            ligneCommande.setId(string);
	            return ligneCommande;
	        }).collect(Collectors.toSet());
	    }
}
